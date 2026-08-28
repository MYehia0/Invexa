package com.example.presentation.ForgotPassword

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.designsystem.components.atoms.InvexaButton
import com.example.designsystem.components.atoms.InvexaTextButton
import com.example.designsystem.components.atoms.InvexaTextField
import com.example.designsystem.components.organisms.InvexaAppBar
import com.example.designsystem.icons.InvexaIcons
import com.example.designsystem.tokens.component.ButtonSize
import com.example.designsystem.tokens.raw.Spacing
import com.example.presentation.R

@Composable
fun ForgotPasswordScreen (
    onSendResetClick: () -> Unit,
    onBackToLoginClick: () -> Unit,
) {
    var emailValue by remember { mutableStateOf("") }

    ForgotPasswordScreenContent(
        emailValue = emailValue,
        onEmailChange = { emailValue = it },
        onSendResetClick = onSendResetClick,
        onBackToLoginClick = onBackToLoginClick
    )
}

@Composable
fun ForgotPasswordScreenContent (
    emailValue: String,
    onEmailChange: (String) -> Unit,
    onSendResetClick: () -> Unit,
    onBackToLoginClick: () -> Unit,
) {
    val scrollState = rememberScrollState()

    val typography = MaterialTheme.typography
    val colors = MaterialTheme.colorScheme

    Scaffold(
        topBar = {
            InvexaAppBar(
                title = stringResource(R.string.forgot_password_top_bar),
                onBackClick = onBackToLoginClick
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(horizontal = Spacing.space450, vertical = Spacing.space600)
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = InvexaIcons.Password,
                contentDescription = null,
                modifier = Modifier
                    .size(48.dp)
            )
            Spacer(Modifier.height(Spacing.space300))
            Text(
                text = stringResource(R.string.forgot_password_title),
                style = typography.titleLarge,
                color = colors.onBackground,
                textAlign = TextAlign.Center
            )
            Text(
                text = stringResource(R.string.forgot_password_description),
                style = typography.bodySmall,
                color = colors.onBackground,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(Spacing.space300))
            InvexaTextField(
                value = emailValue,
                onValueChange = onEmailChange,
                label = stringResource(id = R.string.email_label),
                leadingIcon = InvexaIcons.Email,
                placeholder = stringResource(id = R.string.email_placeholder)
            )
            Spacer(Modifier.height(Spacing.space300))
            InvexaButton(
                onClick = onSendResetClick,
                text = stringResource(id = R.string.send_reset_button),
                modifier = Modifier.fillMaxWidth(),
                size = ButtonSize.Large,
            )
            InvexaTextButton(
                onClick = onBackToLoginClick,
                text = stringResource(id = R.string.back_to_login),
            )

        }
    }
}