package com.example.invexa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.*
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.designsystem.theme.InvexaTheme
import com.example.presentation.login.LoginScreen

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        splashScreen.setKeepOnScreenCondition {
            viewModel.isLoading.value
        }

        setContent {
            InvexaTheme {
                val isLoading by viewModel.isLoading.collectAsState()
                val navController = rememberNavController()
                if (!isLoading) {
                    NavHost(navController = navController, startDestination = "login") {
                        composable("login") {
                            LoginScreen()
                        }
                    }
                }
            }
        }
    }
}