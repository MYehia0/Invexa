package com.example.designsystem.components.molecules

import androidx.compose.animation.core.InfiniteRepeatableSpec
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.designsystem.tokens.raw.Spacing
import com.example.designsystem.tokens.semantic.SemanticShapes

@Composable
fun InvexaSkeleton(
    modifier: Modifier = Modifier,
    width: Dp?,
    height: Dp = 14.dp,
    shape: Shape = RoundedCornerShape(SemanticShapes.shapeXS)
) {
    val transition = rememberInfiniteTransition(label = "skeletonPulse")
    val alpha by transition.animateFloat(
        initialValue = 0.55f,
        targetValue = 1f,
        animationSpec = InfiniteRepeatableSpec(
            animation = tween(durationMillis = 900),
            repeatMode = RepeatMode.Reverse
        ),
        label = "skeletonPulseAlpha",
    )

    val colorScheme = colorScheme

    Box(
        modifier = modifier
            .let{ if (width != null) it.width(width) else it.fillMaxWidth() }
            .height(height)
            .alpha(alpha)
            .background(color =colorScheme.surfaceVariant, shape = shape)
    ) {}
}

@Composable
fun InvexaSkeletonListRow(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        InvexaSkeleton(width = 160.dp, height = 14.dp)
        Spacer(Modifier.height(Spacing.space100))
        InvexaSkeleton(width = 100.dp, height = 12.dp)
    }
}
