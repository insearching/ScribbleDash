package com.insearching.scribbledash.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.insearching.scribbledash.ui.theme.ScribbleDashTheme
import com.insearching.scribbledash.utils.DevicePreview

@Composable
fun ScribbleTextButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = false,
    onClick: () -> Unit
) {
    TextButton(
        modifier = modifier,
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(8.dp, ScribbleDashTheme.colors.surfaceHigh),
        enabled = enabled,
        elevation = ButtonDefaults.elevatedButtonElevation(
            defaultElevation = 10.dp,
            pressedElevation = 0.dp
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = ScribbleDashTheme.colors.success,
            contentColor = ScribbleDashTheme.colors.onPrimary,
            disabledContainerColor = ScribbleDashTheme.colors.surfaceLowest,
            disabledContentColor = ScribbleDashTheme.colors.onPrimary
        ),
        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 16.dp),
        onClick = onClick
    ) {
        Text(
            text = text.uppercase(),
            style = ScribbleDashTheme.typography.headlineSmall,
        )
    }
}

@DevicePreview
@Composable
fun ScribbleTextButtonPreview() {
    ScribbleDashTheme {
        ScribbleTextButton(
            text = "Hello",
            onClick = {}
        )
    }
}

@DevicePreview
@Composable
fun ScribbleTextButtonEnabledPreview() {
    ScribbleDashTheme {
        ScribbleTextButton(
            enabled = true,
            text = "Hello",
            onClick = {}
        )
    }
}