package com.insearching.scribbledash.presentation.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.insearching.scribbledash.ui.theme.ScribbleDashTheme

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    @DrawableRes iconRes: Int,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(22.dp))
            .background(ScribbleDashTheme.colors.surfaceLow.copy(alpha = 0.4f))
            .clickable(onClick = onClick)
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}