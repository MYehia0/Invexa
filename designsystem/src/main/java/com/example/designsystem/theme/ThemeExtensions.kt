package com.example.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import com.example.designsystem.tokens.semantic.SemanticElevation

val MaterialTheme.invexaColors: InvexaExtendedColors
    @Composable
    @ReadOnlyComposable
    get() = LocalInvexaExtendedColors.current

val MaterialTheme.gradients: InvexaGradients
    @Composable
    @ReadOnlyComposable
    get() = LocalInvexaGradients.current

val MaterialTheme.invexaElevation: SemanticElevation
    @Composable
    @ReadOnlyComposable
    get() = LocalInvexaElevation.current