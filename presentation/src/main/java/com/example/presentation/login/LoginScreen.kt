package com.example.presentation.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.designsystem.components.atoms.InvexaButton
import com.example.designsystem.components.atoms.InvexaCheckbox
import com.example.designsystem.components.atoms.InvexaTextButton
import com.example.designsystem.components.atoms.InvexaTextField
import com.example.designsystem.icons.InvexaIcons
import com.example.designsystem.theme.invexaColors
import com.example.designsystem.tokens.component.ButtonSize
import com.example.designsystem.tokens.raw.Spacing
import com.example.presentation.R
import com.example.presentation.login.composables.SecurityFooter
import com.example.presentation.login.composables.HeaderScreen


@Composable
fun LoginScreen(
    onClickLogin: () -> Unit,
    onClickForgotPassword: () -> Unit,
    onClickCreateAccount: () -> Unit
) {
    var emailValue by remember { mutableStateOf("") }
    var passValue by remember { mutableStateOf("") }
    var checkboxOn by remember { mutableStateOf(false) }
    var isPasswordVisible by remember { mutableStateOf(false) }

    LoginScreenContent(
        emailValue = emailValue,
        onEmailChange = { emailValue = it },
        passValue = passValue,
        onPassChange = { passValue = it },
        checkboxOn = checkboxOn,
        onCheckboxChange = { checkboxOn = it },
        isPasswordVisible = isPasswordVisible,
        onPasswordVisibilityToggle = { isPasswordVisible = !isPasswordVisible },
        onClickLogin = onClickLogin,
        onClickForgotPassword = onClickForgotPassword,
        onClickCreateAccount = onClickCreateAccount
    )
}



@Composable
fun LoginScreenContent(
    emailValue: String,
    onEmailChange: (String) -> Unit,
    passValue: String,
    onPassChange: (String) -> Unit,
    checkboxOn: Boolean,
    onCheckboxChange: (Boolean) -> Unit,
    isPasswordVisible: Boolean,
    onPasswordVisibilityToggle: () -> Unit,
    onClickLogin: () -> Unit,
    onClickForgotPassword: () -> Unit,
    onClickCreateAccount: () -> Unit
){

    val scrollState = rememberScrollState()

    val typography = MaterialTheme.typography
    val extend = MaterialTheme.invexaColors
    val colors = MaterialTheme.colorScheme

    Column(
        modifier = Modifier
            .fillMaxSize()
            .imePadding()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .background(colors.background)
                .verticalScroll(scrollState)
        ) {
            HeaderScreen()

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = Spacing.space450, vertical = Spacing.space400),
            ) {
                InvexaTextField(
                    value = emailValue,
                    onValueChange = onEmailChange,
                    label = stringResource(id = R.string.email_label),
                    leadingIcon = InvexaIcons.Email,
                    placeholder = stringResource(id = R.string.email_placeholder)
                )
                Spacer(modifier = Modifier.height(Spacing.space100))
                InvexaTextField(
                    value = passValue,
                    onValueChange = onPassChange,
                    label = stringResource(id = R.string.password_label),
                    isPassword = !isPasswordVisible,
                    leadingIcon = InvexaIcons.Password,
                    placeholder = stringResource(id = R.string.password_placeholder),
                    trailingIcon = if (isPasswordVisible) InvexaIcons.Eye else InvexaIcons.EyeOff ,
                    onTrailingIconClick = onPasswordVisibilityToggle,
                    helperText = stringResource(id = R.string.password_helper_text)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    InvexaCheckbox(
                        label = stringResource(id = R.string.remember_me),
                        checked = checkboxOn,
                        onCheckedChange = onCheckboxChange
                    )
                    InvexaTextButton(
                        text = stringResource(id = R.string.forgot_password),
                        onClick = onClickForgotPassword
                    )
                }
                InvexaButton(
                    onClick = onClickLogin,
                    text = stringResource(id = R.string.login_button),
                    modifier = Modifier.fillMaxWidth(),
                    size = ButtonSize.Large,
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(id = R.string.new_to_invexa),
                        color = extend.textTertiary.copy(alpha = 0.8f),
                        style = typography.bodySmall,
                    )
                    InvexaTextButton(
                        text = stringResource(id = R.string.create_company_account),
                        onClick = onClickCreateAccount
                    )
                }
            }

        }
        SecurityFooter()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        onClickLogin = {},
        onClickForgotPassword = {},
        onClickCreateAccount = {}
    )
}