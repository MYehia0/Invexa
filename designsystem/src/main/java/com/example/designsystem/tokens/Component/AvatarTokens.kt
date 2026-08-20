package com.example.designsystem.tokens.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.gradients

enum class AvatarSize(val diameter : Dp) {
    Small(28.dp),
    Medium(44.dp),
    Large(88.dp),
}

data class AvatarTokens(
    val avatarGradient: List<Color>,
    val avatarInitialsColor: Color,
    val avatarContent: Color,
    val avatarContainer: Color,
)

@Composable
@ReadOnlyComposable
fun avatarTokens(): AvatarTokens {
    val colorScheme = MaterialTheme.colorScheme
    val gradients = MaterialTheme.gradients

    return AvatarTokens(
        avatarGradient = gradients.avatar,
        avatarInitialsColor = colorScheme.onPrimary,
        avatarContent = colorScheme.onPrimary,
        avatarContainer = colorScheme.primary,
    )
}