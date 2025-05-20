package com.insearching.scribbledash.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

//private val ColorScheme = lightColorScheme(
//    primary = primary,
//    onPrimary = onPrimary,
//    secondary = secondary,
//    tertiary = tertiary,
//    error = error,
//    background = background,
//    onBackground = onBackground,
//    surface = surfaceHigh,
//    onSurface = onSurface
//)

@Composable
fun ScribbleDashTheme(
    content: @Composable () -> Unit
) {
//    MaterialTheme(
//        colorScheme = ColorScheme,
//        typography = Typography,
//        content = content
//    )

    CompositionLocalProvider(
        LocalScribbleDashTypography provides ScribbleDashTheme.typography,
        LocalScribbleDashColor provides ScribbleDashTheme.colors,
        content = content
    )
}

object ScribbleDashTheme {

    val typography: ScribbleDashTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalScribbleDashTypography.current

    val colors: ScribbleColor
        @Composable
        @ReadOnlyComposable
        get() = LocalScribbleDashColor.current
}