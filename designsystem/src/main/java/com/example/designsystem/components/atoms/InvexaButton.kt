package com.example.designsystem.components.atoms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.Transparent
import com.example.designsystem.theme.invexaElevation
import com.example.designsystem.theme.invexaShadow
import com.example.designsystem.tokens.component.buttonPrimaryTokens
import com.example.designsystem.tokens.raw.Spacing

@Composable
fun InvexaButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    val tokens = buttonPrimaryTokens()
    val shape = RoundedCornerShape(tokens.shape)

    Button(
        onClick = onClick,
        enabled = enabled,
        shape = shape,

        colors = ButtonDefaults.buttonColors(containerColor = Transparent),
        contentPadding = PaddingValues(horizontal = Spacing.space450, vertical = Spacing.space300),
        modifier = modifier
            .invexaShadow(tokens.shadow, tokens.shape)
            .background(brush = Brush.verticalGradient(tokens.containerGradient), shape = shape),
    ) {
        Text(text = text, color = tokens.content)
    }
}