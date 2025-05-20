package com.insearching.scribbledash.presentation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.insearching.scribbledash.R
import com.insearching.scribbledash.ui.theme.ScribbleDashTheme
import com.insearching.scribbledash.utils.DevicePreview

@Composable
fun OneRoundWonderScreen(
    modifier: Modifier = Modifier,
    onLevelSelected: (Level) -> Unit,
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
                text = stringResource(R.string.start_drawing),
                style = ScribbleDashTheme.typography.displayMedium,
                color = ScribbleDashTheme.colors.onBackground
            )
            Text(
                text = stringResource(R.string.choose_a_difficulty_setting),
                style = ScribbleDashTheme.typography.bodyMedium,
                color = ScribbleDashTheme.colors.onSurface
            )

            Spacer(Modifier.height(48.dp))

            Levels(
                onLevelSelected = onLevelSelected,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}


@Composable
fun Levels(
    modifier: Modifier = Modifier,
    onLevelSelected: (Level) -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp)
    ) {
        Level.entries.forEachIndexed { index, level ->
            DifficultyLevel(
                level = level,
                onClick = {
                    onLevelSelected(level)
                },
                modifier = Modifier.align(if (index % 2 != 0) Alignment.Top else Alignment.Bottom)
            )
        }
    }
}

@Composable
fun DifficultyLevel(
    modifier: Modifier = Modifier,
    level: Level,
    onClick: () -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = level.imageRes),
            contentDescription = "difficulty_level",
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
                .clickable(onClick = onClick)
        )
        Text(
            text = stringResource(level.textRes),
            style = ScribbleDashTheme.typography.labelMedium,
            color = ScribbleDashTheme.colors.onBackground
        )
    }
}

enum class Level(@DrawableRes val imageRes: Int, @StringRes val textRes: Int) {
    Beginner(R.drawable.ic_beginner, R.string.beginner),
    Challenging(R.drawable.ic_challenging, R.string.challenging),
    Master(R.drawable.ic_master, R.string.master)
}

@DevicePreview
@Composable
fun OneRoundWonderScreenPreview() {
    OneRoundWonderScreen(
        onLevelSelected = {},
        onClose = {}
    )
}