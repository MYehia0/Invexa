package com.example.designsystem.tokens.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.example.designsystem.theme.invexaElevation
import com.example.designsystem.tokens.semantic.ElevationLevel
import com.example.designsystem.tokens.semantic.SemanticShapes


data class StatusCardTokens (
    val iconContainer: Color,
    val iconShape: Dp,
)

@Composable
@ReadOnlyComposable
fun statusCardTokens(): StatusCardTokens {
    val colorScheme = MaterialTheme.colorScheme
    return StatusCardTokens(
        iconContainer = colorScheme.primaryContainer,
        iconShape = SemanticShapes.shapeXS
    )
}

data class CardTokens (
    val container: Color,
    val border: Color,
    val shadow: ElevationLevel,
    val shape: Dp
)

@Composable
@ReadOnlyComposable
fun cardTokens(): CardTokens {
    val colorScheme = MaterialTheme.colorScheme
    val elevation = MaterialTheme.invexaElevation

    return CardTokens(
        container = colorScheme.surface,
        border = colorScheme.outline,
        shadow = elevation.level2,
        shape = SemanticShapes.shapeLG
    )
}
