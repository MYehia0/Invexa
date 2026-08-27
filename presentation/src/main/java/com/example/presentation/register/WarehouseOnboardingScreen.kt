package com.example.presentation.register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.designsystem.components.molecules.InvexaStepProgressBar
import com.example.designsystem.components.organisms.InvexaAppBar
import com.example.designsystem.theme.invexaColors
import com.example.designsystem.tokens.raw.Spacing


@Composable
fun WarehouseOnboardingScreen(
    onBackToLogin: () -> Unit
){
    WarehouseOnboardingContent(
        onBackToLogin = onBackToLogin
    )
}

@Composable
fun WarehouseOnboardingContent(
    onBackToLogin: () -> Unit
) {
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            InvexaAppBar(
                onBackClick = onBackToLogin
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(horizontal = Spacing.space500, vertical = Spacing.space600)
                .verticalScroll(scrollState),
        ) {
            InvexaStepProgressBar(totalSteps = 2, currentStep = 2)
            Spacer(modifier = Modifier.height(Spacing.space450))
        }
    }
}