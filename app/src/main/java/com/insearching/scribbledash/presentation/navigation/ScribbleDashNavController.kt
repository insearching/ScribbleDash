package com.insearching.scribbledash.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.insearching.scribbledash.presentation.HomeScreen
import com.insearching.scribbledash.presentation.OneRoundWonderScreen
import com.insearching.scribbledash.presentation.TimeToDrawScreenRoot

@Composable
fun ScribbleNavController(
    modifier: Modifier = Modifier,
    startDestination: Screen,
    controller: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = controller,
        startDestination = startDestination,
    ) {
        composable<Screen.Home> {
            HomeScreen(
                onRoundWounderSelected = {
                    controller.navigate(Screen.OneRoundWounder)
                }
            )
        }
        composable<Screen.OneRoundWounder> {
            OneRoundWonderScreen(
                onLevelSelected = {
                    controller.navigate(Screen.TimeToDrawScreen(it.ordinal))
                },
                onClose = {
                    controller.popBackStack()
                }
            )
        }

        composable<Screen.TimeToDrawScreen> {
            TimeToDrawScreenRoot(
                onClose = {
                    controller.popBackStack()
                }
            )
        }
    }
}