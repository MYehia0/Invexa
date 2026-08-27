package com.example.designsystem.components.molecules

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.designsystem.tokens.raw.Spacing

@Composable
fun InvexaStepProgressBar(
    totalSteps: Int,
    currentStep: Int,
    modifier: Modifier = Modifier
) {
     LinearProgressIndicator(
         progress = { currentStep / totalSteps.toFloat() },
         modifier = modifier.fillMaxWidth(),
         color = MaterialTheme.colorScheme.primary,
         trackColor = MaterialTheme.colorScheme.primaryContainer,
     )
}