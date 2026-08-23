package com.example.designsystem.tokens.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import com.example.designsystem.theme.gradients
import com.example.designsystem.theme.invexaColors
import com.example.designsystem.theme.invexaElevation
import com.example.designsystem.tokens.semantic.ElevationLevel

data class BottomNavTokens(
    val container: Color,
    val border: Color,
    val itemActive: Color,
    val itemInactive: Color,
    val scanFabGradient: List<Color>,
    val scanFabGlow: ElevationLevel,
    val topBorderGradient: List<Color>,
)

@Composable
@ReadOnlyComposable
fun bottomNavTokens(): BottomNavTokens {
    val colorScheme = MaterialTheme.colorScheme
    val extended = MaterialTheme.invexaColors
    val gradients = MaterialTheme.gradients
    val elevation = MaterialTheme.invexaElevation

    return BottomNavTokens(
        container = colorScheme.surface,
        border = colorScheme.outlineVariant,
        itemActive = colorScheme.primary,
        itemInactive = extended.textTertiary,
        scanFabGradient = gradients.primaryButton,
        scanFabGlow = elevation.glowScan,
        topBorderGradient = gradients.primaryButton,
    )
}