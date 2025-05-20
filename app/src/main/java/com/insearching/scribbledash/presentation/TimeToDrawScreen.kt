package com.insearching.scribbledash.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.insearching.scribbledash.R
import com.insearching.scribbledash.presentation.components.ActionButton
import com.insearching.scribbledash.presentation.components.DrawingCanvas
import com.insearching.scribbledash.presentation.components.ScribbleTextButton
import com.insearching.scribbledash.ui.theme.ScribbleDashTheme
import com.insearching.scribbledash.utils.DevicePreview
import org.koin.androidx.compose.koinViewModel

@Composable
fun TimeToDrawScreenRoot(
    modifier: Modifier = Modifier,
    viewModel: DrawingViewModel = koinViewModel<DrawingViewModel>(),
    onClose: () -> Unit,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    TimeToDrawScreen(
        modifier = modifier,
        state = state,
        onAction = viewModel::onAction,
        onClose = onClose
    )
}

@Composable
fun TimeToDrawScreen(
    modifier: Modifier = Modifier,
    state: DrawingState,
    onAction: (DrawingAction) -> Unit,
    onClose: () -> Unit,
) {

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(ScribbleDashTheme.colors.backgroundGradient))
            .padding(16.dp)
    ) {
        IconButton(
            onClick = onClose,
            modifier = Modifier.align(Alignment.TopEnd)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_close),
                contentDescription = "close",
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.align(Alignment.Center)
        ) {
            Text(
                text = stringResource(R.string.time_to_draw),
                style = ScribbleDashTheme.typography.displayMedium,
                color = ScribbleDashTheme.colors.onBackground
            )
            Spacer(Modifier.height(48.dp))
            DrawingCanvas(
                paths = state.paths,
                currentPath = state.currentPath,
                onAction = onAction,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f / 1f)
            )
        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        ) {
            ActionButton(
                iconRes = R.drawable.ic_undo,
                onClick = { onAction(DrawingAction.OnUndoClick) },
                enabled = state.paths.isNotEmpty(),
                modifier = Modifier.size(64.dp)
            )
            ActionButton(
                iconRes = R.drawable.ic_redo,
                onClick = { onAction(DrawingAction.OnRedoClick) },
                enabled = state.redoEnabled,
                modifier = Modifier.size(64.dp)
            )
            ScribbleTextButton(
                enabled = state.paths.isNotEmpty(),
                text = stringResource(R.string.clear_canvas),
                onClick = { onAction(DrawingAction.OnClearCanvasClick) },
            )
        }
    }
}


@DevicePreview
@Composable
fun TimeToDrawScreenPreview() {
    TimeToDrawScreen(
        state = DrawingState(),
        onAction = {},
        onClose = {}
    )
}