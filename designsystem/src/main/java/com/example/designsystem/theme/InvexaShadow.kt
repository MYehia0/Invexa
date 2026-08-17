package com.example.designsystem.theme

import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.designsystem.tokens.semantic.ElevationLevel

fun Modifier.invexaShadow(level: ElevationLevel, shape: Dp): Modifier {
    var result = this
    level.shadows.forEach { layer ->
        result = result.shadow(
            elevation = layer.blurRadius,
            shape = RoundedCornerShape(shape),
            ambientColor = layer.color.copy(alpha = layer.alpha),
            spotColor = layer.color.copy(alpha = layer.alpha),
        )
    }
    level.borderColor?.let { border ->
        result = result.border(1.dp, border, RoundedCornerShape(shape))
    }
    return result
}