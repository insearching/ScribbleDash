package com.insearching.scribbledash.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun HomeScreen(
    modifier: Modifier = Modifier,
    onRoundWounderSelected: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(ScribbleDashTheme.colors.backgroundGradient))
            .padding(16.dp)
    ) {
        Text(
            text = stringResource(R.string.app_name),
            style = ScribbleDashTheme.typography.headlineMedium,
            color = ScribbleDashTheme.colors.onBackground
        )

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
                text = stringResource(R.string.select_game_mode),
                style = ScribbleDashTheme.typography.bodyMedium,
                color = ScribbleDashTheme.colors.onSurface
            )
            Spacer(Modifier.height(24.dp))
            OneRoundWonder(
                onClick = onRoundWounderSelected
            )
        }
    }
}

@Composable
fun OneRoundWonder(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .border(8.dp, ScribbleDashTheme.colors.success, RoundedCornerShape(20.dp))
            .fillMaxWidth()
            .background(ScribbleDashTheme.colors.surfaceHigh)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.one_round_wonder),
                style = ScribbleDashTheme.typography.headlineSmall,
                color = ScribbleDashTheme.colors.onBackground,
                modifier = Modifier
                    .padding(start = 22.dp)
            )
            Image(
                painter = painterResource(R.drawable.one_round_wonder),
                contentDescription = "one_round"
            )
        }
    }
}

@DevicePreview
@Composable
fun HomeScreenPreview() {
    ScribbleDashTheme {
        HomeScreen(
            onRoundWounderSelected = {}
        )
    }
}