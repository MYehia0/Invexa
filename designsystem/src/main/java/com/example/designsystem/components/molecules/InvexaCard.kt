package com.example.designsystem.components.molecules

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.invexaColors
import com.example.designsystem.theme.invexaShadow
import com.example.designsystem.tokens.component.cardTokens
import com.example.designsystem.tokens.component.statusCardTokens
import com.example.designsystem.tokens.raw.Spacing

@Composable
fun InvexaCard(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit,
){
    val tokens = cardTokens()
    val shape = RoundedCornerShape(tokens.shape)

    Column(
        modifier = modifier
            .invexaShadow(tokens.shadow, tokens.shape)
            .background(tokens.container, shape)
            .border(1.dp, tokens.border, shape)
            .padding(Spacing.space450),
        content = content
    )
}

@Composable
fun InvexaStatusCard(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    value: String,
    label: String,
    progressFraction: Float? = null,
){
    val tokens = statusCardTokens()
    val extended = MaterialTheme.invexaColors

    InvexaCard(
        modifier = modifier
    ){
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(32.dp)
                .background(tokens.iconContainer, RoundedCornerShape(tokens.iconShape)),
        ) {
            Icon(icon, contentDescription = null, tint = extended.textPrimary)
        }
        Spacer(Modifier.height(Spacing.space200))
        Text(text = value, color = extended.textPrimary)
        Text(text = label, color = extended.textSecondary)
        if (progressFraction != null) {
            Spacer(Modifier.height(Spacing.space200))
            InvexaProgressBar(fraction = progressFraction)
        }
    }
}