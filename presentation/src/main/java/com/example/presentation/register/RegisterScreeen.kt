package com.example.presentation.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.res.stringResource
import com.example.designsystem.components.atoms.InvexaButton
import com.example.designsystem.components.atoms.InvexaCheckbox
import com.example.designsystem.components.atoms.InvexaTextButton
import com.example.designsystem.components.atoms.InvexaTextField
import com.example.designsystem.components.molecules.InvexaStepProgressBar
import com.example.designsystem.components.organisms.InvexaAppBar
import com.example.designsystem.icons.InvexaIcons
import com.example.designsystem.theme.invexaColors
import com.example.designsystem.tokens.component.ButtonSize
import com.example.designsystem.tokens.raw.Spacing
import com.example.presentation.R

@Composable
fun RegisterScreen (
    onClickCreateAccount: () -> Unit,
    onBackToLogin: () -> Unit
) {
    var emailValue by remember { mutableStateOf("") }
    var companyNameValue by remember { mutableStateOf("") }
    var fullNameValue by remember { mutableStateOf("") }
    var passValue by remember { mutableStateOf("") }
    var checkboxOn by remember { mutableStateOf(false) }
    var isPasswordVisible by remember { mutableStateOf(false) }

    RegisterScreenContent(
        companyNameValue = companyNameValue,
        onCompanyNameChange = { companyNameValue = it },
        fullNameValue = fullNameValue,
        onFullNameChange = { fullNameValue = it },
        emailValue = emailValue,
        onEmailChange = { emailValue = it },
        passValue = passValue,
        onPassChange = { passValue = it },
        checkboxOn = checkboxOn,
        onCheckboxChange = { checkboxOn = it },
        isPasswordVisible = isPasswordVisible,
        onPasswordVisibilityToggle = { isPasswordVisible = !isPasswordVisible },
        onClickCreateAccount = onClickCreateAccount,
        onBackToLogin = onBackToLogin
    )
}

@Composable
fun RegisterScreenContent (
    companyNameValue: String,
    onCompanyNameChange: (String) -> Unit,
    fullNameValue: String,
    onFullNameChange: (String) -> Unit,
    emailValue: String,
    onEmailChange: (String) -> Unit,
    passValue: String,
    onPassChange: (String) -> Unit,
    checkboxOn: Boolean,
    onCheckboxChange: (Boolean) -> Unit,
    isPasswordVisible: Boolean,
    onPasswordVisibilityToggle: () -> Unit,
    onClickCreateAccount: () -> Unit,
    onBackToLogin: () -> Unit
) {
    val scrollState = rememberScrollState()

    val typography = MaterialTheme.typography
    val colors = MaterialTheme.colorScheme
    val extend = MaterialTheme.invexaColors

    Scaffold(
        topBar = {
            InvexaAppBar(
                onBackClick = onBackToLogin
            )
        }
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(horizontal = Spacing.space500, vertical = Spacing.space600)
                .verticalScroll(scrollState),
        ) {
            InvexaStepProgressBar(totalSteps = 2, currentStep = 1)
            Spacer(modifier = Modifier.height(Spacing.space450))

            Text(
                text = stringResource(R.string.register_title),
                style = typography.titleLarge
            )
            Spacer(modifier = Modifier.height(Spacing.space100))
            Text(
                text = stringResource(R.string.register_description),
                style = typography.bodySmall,
                color = colors.onSurfaceVariant
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(Spacing.space400)
            ) {

                InvexaTextField(
                    value = companyNameValue,
                    onValueChange = onCompanyNameChange,
                    label = stringResource(id = R.string.company_name_label),
                    leadingIcon = InvexaIcons.Company,
                    placeholder = stringResource(id = R.string.company_name_placeholder)
                )
                InvexaTextField(
                    value = fullNameValue,
                    onValueChange = onFullNameChange,
                    label = stringResource(id = R.string.full_name_label),
                    leadingIcon = InvexaIcons.Username,
                    placeholder = stringResource(id = R.string.full_name_placeholder)
                )

                InvexaTextField(
                    value = emailValue,
                    onValueChange = onEmailChange,
                    label = stringResource(id = R.string.email_label),
                    leadingIcon = InvexaIcons.Email,
                    placeholder = stringResource(id = R.string.email_placeholder)
                )
                InvexaTextField(
                    value = passValue,
                    onValueChange = onPassChange,
                    label = stringResource(id = R.string.password_label),
                    isPassword = !isPasswordVisible,
                    leadingIcon = InvexaIcons.Password,
                    placeholder = stringResource(id = R.string.create_password_placeholder),
                    trailingIcon = if (isPasswordVisible) InvexaIcons.Eye else InvexaIcons.EyeOff ,
                    onTrailingIconClick = onPasswordVisibilityToggle,
                    helperText = stringResource(id = R.string.password_helper_text)
                )

                InvexaCheckbox(
                    label = stringResource(id = R.string.terms_and_privacy),
                    checked = checkboxOn,
                    onCheckedChange = onCheckboxChange,
                    modifier = Modifier.fillMaxWidth()
                )

                InvexaButton(
                    onClick = onClickCreateAccount,
                    text = stringResource(id = R.string.create_account_button),
                    modifier = Modifier.fillMaxWidth(),
                    size = ButtonSize.Large,
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(id = R.string.already_have_an_account),
                        color = extend.textTertiary.copy(alpha = 0.8f),
                        style = typography.bodySmall,
                    )
                    InvexaTextButton(
                        text = stringResource(id = R.string.login_button),
                        onClick = onBackToLogin
                    )
                }

            }
        }
    }
}