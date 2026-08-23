package com.example.designsystem.components.organisms

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.invexaShadow
import com.example.designsystem.tokens.component.centerFabTokens
import com.example.designsystem.tokens.semantic.SemanticShapes

@Composable
fun InvexaCenterFab(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    label: String? = null,
    onFabClick: () -> Unit
) {
    val tokens = centerFabTokens()

    Column(
        modifier = modifier
                .offset(y = (64).dp)
            .wrapContentSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(64.dp)
                .invexaShadow(
                    level = tokens.fabGlow,
                    cornerRadius = SemanticShapes.shapeFull
                )
                .clip(CircleShape)
                .background(Brush.linearGradient(tokens.fabGradient))
                .clickable { onFabClick() },
            contentAlignment = Alignment.Center
        ){
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = Color.White,
                modifier = Modifier.size(32.dp)
            )
        }
        label?.let {
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = it,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}