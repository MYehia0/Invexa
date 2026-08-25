package com.example.invexa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.designsystem.preview.Screen
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val isLoading by viewModel.isLoading.collectAsState()

            // 1. Crossfade creates a smooth dissolve between the Splash and Main App
            Crossfade(
                targetState = isLoading,
                animationSpec = tween(durationMillis = 600), // 600ms dissolve transition
                label = "SplashTransition"
            ) { loading ->
                if (loading) {
                    SplashScreen()
                } else {
                    Screen()
                }
            }
        }
    }
}

// ViewModel remains unchanged
class MainViewModel : ViewModel() {
    private val _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()

    init {
        viewModelScope.launch {
            delay(2000)
            _isLoading.value = false
        }
    }
}

@Composable
fun SplashScreen() {
    // State to trigger the fade-in animation
    var startAnimation by remember { mutableStateOf(false) }

    // Fires exactly once when the Splash Screen enters the layout
    LaunchedEffect(Unit) {
        startAnimation = true
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF2563EB)),
        contentAlignment = Alignment.Center
    ) {

        // The App Icon remains completely static to ensure a perfect handoff
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "App Logo",
            modifier = Modifier.size(120.dp)
        )

        // 2. AnimatedVisibility softly fades the text and spinner in
        AnimatedVisibility(
            visible = startAnimation,
            enter = fadeIn(animationSpec = tween(durationMillis = 800)),
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = 160.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "Invexa",
                    color = Color.White,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Loading your portfolio...",
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.height(32.dp))

                CircularProgressIndicator(
                    color = Color.White,
                    trackColor = Color.White.copy(alpha = 0.2f)
                )
            }
        }
    }
}