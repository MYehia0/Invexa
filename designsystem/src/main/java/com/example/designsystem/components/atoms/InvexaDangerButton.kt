package com.example.designsystem.components.atoms

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.designsystem.tokens.component.ButtonSize
import com.example.designsystem.tokens.component.contentPadding
import com.example.designsystem.tokens.component.dangerButtonTokens

@Composable
fun InvexaDangerButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
    size: ButtonSize = ButtonSize.Medium,
) {
    val tokens = dangerButtonTokens()
    Button(
        onClick = onClick,
        enabled = enabled,
        shape = RoundedCornerShape(tokens.shape),
        colors = ButtonDefaults.buttonColors(containerColor = tokens.container, contentColor = tokens.content),
        contentPadding = size.contentPadding(),
        modifier = modifier,
    ) {
        Text(text = text, color = tokens.content)
    }
}