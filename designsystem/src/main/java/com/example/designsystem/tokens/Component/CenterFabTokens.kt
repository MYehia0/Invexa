package com.example.designsystem.tokens.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import com.example.designsystem.theme.gradients
import com.example.designsystem.theme.invexaElevation
import com.example.designsystem.tokens.semantic.ElevationLevel

data class CenterFabTokens(
    val fabGradient: List<Color>,
    val fabGlow: ElevationLevel,
)

@Composable
@ReadOnlyComposable
fun centerFabTokens(): CenterFabTokens {
    val gradients = MaterialTheme.gradients
    val elevation = MaterialTheme.invexaElevation

    return CenterFabTokens(
        fabGradient = gradients.primaryButton,
        fabGlow = elevation.glowScan,
    )
}