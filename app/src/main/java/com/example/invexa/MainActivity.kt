package com.example.invexa

import android.app.Activity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalView
import androidx.core.os.LocaleListCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
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

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        applyLocale(AppLanguage.SYSTEM)

        splashScreen.setKeepOnScreenCondition {
            viewModel.isLoading.value
        }

        setContent {
            val isAppInDarkTheme = false
//            val isAppInDarkTheme = true

            val view = LocalView.current
            SideEffect {
                val window = (view.context as Activity).window
                WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !isAppInDarkTheme
            }
            InvexaTheme(
                darkTheme = isAppInDarkTheme
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

enum class AppLanguage(val tag: String) {
    SYSTEM(""),      // empty tag = follow system
    ENGLISH("en"),
    ARABIC("ar");

    companion object {
        fun fromTag(tag: String?) = entries.firstOrNull { it.tag == tag } ?: SYSTEM
    }
}

private fun applyLocale(language: AppLanguage) {
    val locales = if (language == AppLanguage.SYSTEM)
        LocaleListCompat.getEmptyLocaleList()
    else
        LocaleListCompat.forLanguageTags(language.tag)
    AppCompatDelegate.setApplicationLocales(locales)
}