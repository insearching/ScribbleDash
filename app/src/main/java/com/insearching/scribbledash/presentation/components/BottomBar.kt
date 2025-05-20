package com.insearching.scribbledash.presentation.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.insearching.scribbledash.R
import com.insearching.scribbledash.ui.theme.ScribbleDashTheme
import com.insearching.scribbledash.utils.DevicePreview

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    selectedOption: BottomBarType = BottomBarType.Home,
    onTabSelected: (BottomBarType) -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
            .fillMaxWidth()
            .background(ScribbleDashTheme.colors.surfaceHigh)
    ) {
        BottomBarType.entries.forEach { barType ->
            IconButton(
                onClick = { onTabSelected(barType) },
            ) {
                val isSelected = BottomBarType.entries.firstNotNullOf { barType == selectedOption }
                Icon(
                    painter = painterResource(id = barType.iconRes),
                    contentDescription = null,
                    tint = if (isSelected) ScribbleDashTheme.colors.primary
                    else ScribbleDashTheme.colors.surfaceLowest
                )
            }
        }
    }
}

enum class BottomBarType(@DrawableRes val iconRes: Int) {
    Stats(R.drawable.ic_stats),
    Home(R.drawable.ic_home),
}

@DevicePreview
@Composable
fun BottomBarPreview() {
    ScribbleDashTheme {
        BottomBar(
            selectedOption = BottomBarType.Home,
            onTabSelected = {}
        )
    }
}