package com.example.designsystem.tokens.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.example.designsystem.theme.invexaColors
import com.example.designsystem.tokens.semantic.SemanticShapes

enum class BadgeTone {
    Neutral,
    Primary,
    Success,
    Warning,
    Error,
}

data class BadgeTokens(
    val container: Color,
    val content: Color,
    val shape: Dp,
)

@Composable
@ReadOnlyComposable
fun badgeTokens(tone: BadgeTone): BadgeTokens {
    val colorScheme = MaterialTheme.colorScheme
    val extended = MaterialTheme.invexaColors

    val (container, content) = when (tone) {
        BadgeTone.Neutral -> colorScheme.surfaceVariant to extended.textSecondary
        BadgeTone.Primary -> colorScheme.primaryContainer to colorScheme.onPrimaryContainer
        BadgeTone.Success -> extended.successContainer to extended.onSuccessContainer
        BadgeTone.Warning -> extended.warningContainer to extended.onWarningContainer
        BadgeTone.Error -> colorScheme.errorContainer to colorScheme.onErrorContainer
    }
    return BadgeTokens(
        container = container,
        content = content,
        shape = SemanticShapes.shapeXS,
    )
}