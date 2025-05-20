package com.insearching.scribbledash.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.insearching.scribbledash.R

private val bagel_fat_one = FontFamily(
    Font(
        resId = R.font.bagel_fat_one,
        weight = FontWeight.Normal
    ),
)

private val outfit_regular = FontFamily(
    Font(
        resId = R.font.outfit_regular,
        weight = FontWeight.Normal
    ),
)

private val outfit_medium = FontFamily(
    Font(
        resId = R.font.outfit_medium,
        weight = FontWeight.Medium
    ),
)

data class ScribbleDashTypography(

    val headlineSmall: TextStyle =  TextStyle(
        fontFamily = bagel_fat_one,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        lineHeight = 26.sp,
        letterSpacing = 0.sp
    ),
    val headlineMedium: TextStyle =  TextStyle(
        fontFamily = bagel_fat_one,
        fontWeight = FontWeight.Normal,
        fontSize = 34.sp,
        lineHeight = 48.sp,
        letterSpacing = 0.sp
    ),
    val headlineLarge: TextStyle =  TextStyle(
        fontFamily = bagel_fat_one,
        fontWeight = FontWeight.Normal,
        fontSize = 26.sp,
        lineHeight = 30.sp,
        letterSpacing = 0.sp
    ),

    val displayLarge: TextStyle =  TextStyle(
        fontFamily = bagel_fat_one,
        fontWeight = FontWeight.Normal,
        fontSize = 66.sp,
        lineHeight = 80.sp,
        letterSpacing = 0.sp
    ),
    val displayMedium: TextStyle =  TextStyle(
        fontFamily = bagel_fat_one,
        fontWeight = FontWeight.Normal,
        fontSize = 40.sp,
        lineHeight = 44.sp,
        letterSpacing = 0.sp
    ),

    val bodyLarge: TextStyle =  TextStyle(
        fontFamily = outfit_medium,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    ),
    val bodyMedium: TextStyle =  TextStyle(
        fontFamily = outfit_regular,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    ),
    val bodySmall: TextStyle =  TextStyle(
        fontFamily = outfit_regular,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.sp
    ),

    val labelLarge: TextStyle =  TextStyle(
        fontFamily = outfit_medium,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    ),
    val labelMedium: TextStyle =  TextStyle(
        fontFamily = outfit_regular,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    ),
    val labelSmall: TextStyle =  TextStyle(
        fontFamily = outfit_regular,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.sp
    )
)

internal val LocalScribbleDashTypography = staticCompositionLocalOf {
    ScribbleDashTypography()
}