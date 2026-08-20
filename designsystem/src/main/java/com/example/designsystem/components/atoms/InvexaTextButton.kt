package com.example.designsystem.components.atoms

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.designsystem.tokens.component.ghostButtonTokens

@Composable
fun InvexaTextButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
) {
    val tokens = ghostButtonTokens()
    TextButton(
        onClick = onClick,
        enabled = enabled,
        shape = RoundedCornerShape(tokens.shape),
        modifier = modifier,
    ) {
        Text(text = text, color = tokens.content)
    }
}