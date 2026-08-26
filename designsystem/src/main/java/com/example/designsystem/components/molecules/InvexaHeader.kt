package com.example.designsystem.components.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.gradients
import com.example.designsystem.tokens.semantic.SemanticShapes

@Composable
fun InvexaHeader(
    modifier: Modifier = Modifier,
    heightHeader: Dp = 180.dp,
    alignment: Alignment = Alignment.TopStart,
    content: @Composable () -> Unit
) {
    val gradients = MaterialTheme.gradients

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(heightHeader)
            .clip(RoundedCornerShape(
                bottomStart = SemanticShapes.shapeXL,
                bottomEnd = SemanticShapes.shapeXL,
                )
            )
            .background(
                brush = Brush.verticalGradient(colors = gradients.primaryHero)
            ),
        contentAlignment = alignment
    ) {
        content.invoke()
    }
}