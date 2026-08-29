package com.example.designsystem.tokens.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.example.designsystem.theme.invexaElevation
import com.example.designsystem.tokens.semantic.ElevationLevel
import com.example.designsystem.tokens.semantic.SemanticShapes

data class ListRowTokens (
    val container: Color,
    val border: Color,
    val shadow: ElevationLevel,
    val shape: Dp
)

@Composable
@ReadOnlyComposable
fun listRowTokens(): ListRowTokens {
    val colorScheme = MaterialTheme.colorScheme
    val elevation = MaterialTheme.invexaElevation

    return ListRowTokens(
        container = colorScheme.surface,
        border = colorScheme.outline,
        shadow = elevation.level2,
        shape = SemanticShapes.shapeLG
    )
}