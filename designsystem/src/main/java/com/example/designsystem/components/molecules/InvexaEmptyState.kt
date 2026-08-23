package com.example.designsystem.components.molecules

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import com.example.designsystem.components.atoms.InvexaButton
import com.example.designsystem.theme.invexaColors
import com.example.designsystem.tokens.raw.Spacing

@Composable
fun InvexaEmptyState(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    title: String,
    description: String? = null,
    buttonText: String? = null,
    onButtonClick: (() -> Unit) ? = null,
){
    val extended = MaterialTheme.invexaColors

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(Spacing.space800),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = extended.iconMuted,
            modifier = Modifier.padding(bottom = Spacing.space400),
        )
        Text(text = title, color = extended.textPrimary, textAlign = TextAlign.Center)
        description?.let{
            Text(
                text = it,
                color = extended.textSecondary,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = Spacing.space100),
            )
        }
        if(buttonText != null && onButtonClick != null){
            InvexaButton(
                text = buttonText,
                onClick = onButtonClick,
                modifier = Modifier.padding(top = Spacing.space400)
            )
        }
    }
}