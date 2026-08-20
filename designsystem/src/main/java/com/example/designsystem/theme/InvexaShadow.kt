package com.example.designsystem.theme

import android.graphics.BlurMaskFilter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativePaint
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.designsystem.tokens.semantic.ElevationLevel

fun Modifier.invexaShadow(level: ElevationLevel, cornerRadius: Dp): Modifier = this.drawBehind {
    val radiusPx = cornerRadius.toPx()
    level.shadows.forEach { layer ->
        drawIntoCanvas { canvas ->
            val paint = Paint().apply {
                color = layer.color.copy(alpha = layer.alpha)
            }
            val frameworkPaint = paint.nativePaint
            if (layer.blurRadius > 0.dp) {
                frameworkPaint.maskFilter = BlurMaskFilter(
                    layer.blurRadius.toPx(),
                    BlurMaskFilter.Blur.NORMAL,
                )
            }
            val left = layer.offsetX.toPx()
            val top = layer.offsetY.toPx()
            canvas.drawRoundRect(
                left = left,
                top = top,
                right = left + size.width,
                bottom = top + size.height,
                radiusX = radiusPx,
                radiusY = radiusPx,
                paint = paint,
            )
        }
    }
}