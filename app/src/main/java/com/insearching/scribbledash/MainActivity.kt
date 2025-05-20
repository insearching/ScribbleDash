package com.insearching.scribbledash

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.insearching.scribbledash.presentation.navigation.Screen
import com.insearching.scribbledash.presentation.navigation.ScribbleNavController
import com.insearching.scribbledash.ui.theme.ScribbleDashTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ScribbleDashTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ScribbleNavController(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        startDestination = Screen.Home,
                        controller = navController,
                    )
                }
            }
        }
    }
}