package com.example.designsystem.tokens.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.example.designsystem.tokens.semantic.SemanticShapes

data class ChipTokens(
    val containerSelected: Color,
    val containerUnselected: Color,
    val contentSelected: Color,
    val contentUnselected: Color,
    val border: Color,
    val shape: Dp,
)

@Composable
@ReadOnlyComposable
fun chipTokens(): ChipTokens {
    val colorScheme = MaterialTheme.colorScheme
    return ChipTokens(
        containerSelected = colorScheme.primary,
        containerUnselected = colorScheme.background,
        contentSelected = colorScheme.onPrimary,
        contentUnselected = colorScheme.onSurface,
        border = colorScheme.outline,
        shape = SemanticShapes.shapeXS,
    )
}