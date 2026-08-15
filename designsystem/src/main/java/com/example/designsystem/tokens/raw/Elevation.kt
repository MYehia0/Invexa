package com.example.designsystem.tokens.raw

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class ShadowLayer(
    val offsetX: Dp = 0.dp,
    val offsetY: Dp,
    val blurRadius: Dp,
    val color: Color,
    val alpha: Float
)

fun List<ShadowLayer>.dimmed(factor: Float): List<ShadowLayer> =
    map { it.copy(alpha = it.alpha * factor) }

object Elevation {
    val shadow100 = listOf(
        ShadowLayer(offsetY = 1.dp, blurRadius = 2.dp, color = ColorPalette.neutral.n950, alpha = 0.05f),
        ShadowLayer(offsetY = 1.dp, blurRadius = 1.dp, color = ColorPalette.neutral.n950, alpha = 0.03f)
    )
    val shadow200 = listOf(
        ShadowLayer(offsetY = 10.dp, blurRadius = 30.dp, color = ColorPalette.neutral.n950, alpha = 0.06f),
        ShadowLayer(offsetY = 2.dp, blurRadius = 6.dp, color = ColorPalette.neutral.n950, alpha = 0.04f)
    )
    val shadow300 = listOf(
        ShadowLayer(offsetY = 20.dp, blurRadius = 48.dp, color = ColorPalette.neutral.n950, alpha = 0.10f),
        ShadowLayer(offsetY = 4.dp, blurRadius = 12.dp, color = ColorPalette.neutral.n950, alpha = 0.05f)
    )
    val glowBlue = listOf(
        ShadowLayer(offsetY = 6.dp, blurRadius = 16.dp, color = ColorPalette.blue.t600, alpha = 0.28f)
    )
    val glowViolet = listOf(
        ShadowLayer(offsetY = 10.dp, blurRadius = 22.dp, color = ColorPalette.violet.t600, alpha = 0.55f)
    )
}