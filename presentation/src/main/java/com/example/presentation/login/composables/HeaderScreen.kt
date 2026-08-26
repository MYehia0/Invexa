package com.example.presentation.login.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.designsystem.components.molecules.InvexaHeader
import com.example.designsystem.tokens.raw.Spacing
import com.example.presentation.R

@Composable
fun HeaderScreen() {
    val typography = MaterialTheme.typography
    InvexaHeader(
        heightHeader = 280.dp,
        alignment = Alignment.BottomStart
    ) {
        Column(
            modifier = Modifier.padding(
                top = Spacing.space800,
                bottom = Spacing.space600,
                start = Spacing.space300,
                end = Spacing.space600
            ),
            verticalArrangement = Arrangement.spacedBy(Spacing.space100)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.ic_logo),
                    contentDescription = null,
                    modifier = Modifier.size(48.dp)
                )
                Text(
                    text = stringResource(id = R.string.app_name),
                    color = Color.White,
                    style = typography.titleMedium,
                )
            }
            Text(
                text = stringResource(id = R.string.welcome_back),
                color = Color.White,
                style = typography.headlineLarge,
                modifier = Modifier.padding(start = Spacing.space300)
            )
            Text(
                text = stringResource(id = R.string.sign_in_to_continue),
                color = Color.White.copy(alpha = 0.8f),
                style = typography.bodySmall,
                modifier = Modifier.padding(start = Spacing.space300)
            )

        }
    }
}