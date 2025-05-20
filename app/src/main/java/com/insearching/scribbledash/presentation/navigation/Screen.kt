package com.insearching.scribbledash.presentation.navigation

import kotlinx.serialization.Serializable

sealed class Screen {

    @Serializable
    data object Home : Screen()

    @Serializable
    data object OneRoundWounder : Screen()

    @Serializable
    data class TimeToDrawScreen(val levelId: Int) : Screen()

}