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
import com.example.designsystem.preview.Screen
import com.example.designsystem.theme.InvexaTheme
import com.example.presentation.ForgotPassword.ForgotPasswordScreen
import com.example.presentation.home.HomeScreen
import com.example.presentation.login.LoginScreen
import com.example.presentation.register.RegisterScreen
import com.example.presentation.register.WarehouseOnboardingScreen

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
            InvexaTheme(
                darkTheme = false
            ) {
                val isLoading by viewModel.isLoading.collectAsState()
                val navController = rememberNavController()
                if (!isLoading) {
                    NavHost(navController = navController, startDestination = "login") {
                        composable("login") {
                            LoginScreen(
                                onClickLogin = {
//                                    navController.navigate("preview")
                                    navController.navigate("home")
                                },
                                onClickForgotPassword = {
                                    navController.navigate("forgot_password")
                                },
                                onClickCreateAccount = {
                                    navController.navigate("register")
                                },
                            )
                        }
                        composable("register") {
                            RegisterScreen(
                                onClickCreateAccount = {
                                    navController.navigate("warehouse_onboarding")
                                },
                                onBack = {
                                    navController.popBackStack()
                                }
                            )
                        }
                        composable("warehouse_onboarding") {
                            WarehouseOnboardingScreen(
                                onFinishSetupClick = {
//                                    navController.navigate("preview")
                                    navController.navigate("home")
                                },
                                onSkipClick = {
//                                    navController.navigate("preview")
                                    navController.navigate("home")

                                },
                                onBack = {
                                    navController.popBackStack()
                                }
                            )
                        }
                        composable("forgot_password") {
                            ForgotPasswordScreen(
                                onSendResetClick = {},
                                onBackToLoginClick = {
                                    navController.popBackStack()
                                }
                            )
                        }
                        composable("home") {
                            HomeScreen()
                        }
                        composable("preview") {
                            Screen()
                        }
                    }
                }
            }
        }
    }
}