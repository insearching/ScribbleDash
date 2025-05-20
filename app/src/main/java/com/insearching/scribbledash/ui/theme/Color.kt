package com.insearching.scribbledash.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class ScribbleColor(
    val primary: Color = Color(0xFF238CFF),
    val onPrimary: Color = Color(0xFFFFFFFF),
    val secondary: Color = Color(0xFFFFFFFF),
    val tertiary: Color = Color(0xFFFA852C),
    val error: Color = Color(0xFFEF1242),
    val success: Color = Color(0xFF0DD280),
    val background: Color = Color(0xFFFEFAF6),
    val onBackground: Color = Color(0xFF514437),
    val onBackgroundVar: Color = Color(0xFF7F7163),
    val backgroundGradient: List<Color> = listOf(Color(0xFFFEFAF6), Color(0xFFFFF1E2)),
    val surfaceHigh: Color = Color(0xFFFFFFFF),
    val onSurface: Color = Color(0xFF7F7163),
    val surfaceLow: Color = Color(0xFFEEE7E0),
    val surfaceLowest: Color = Color(0xFFEEE7E0),
    val onSurfaceVar: Color = Color(0xFFF6F1EC),
    val streakGradient: List<Color> = listOf(Color(0xFF00F9FC), Color(0xFF0081FC)),
    val streakLostGradient: List<Color> = listOf(Color(0xFFDE004C), Color(0xFFFF003B)),
    val highScoreGradient: List<Color> = listOf(Color(0xFFFF9600), Color(0xFFFFDA35))
)


internal val LocalScribbleDashColor = staticCompositionLocalOf {
    ScribbleColor()
}