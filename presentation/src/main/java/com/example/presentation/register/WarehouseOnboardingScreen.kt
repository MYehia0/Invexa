package com.example.presentation.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.text.style.TextAlign
import com.example.designsystem.components.atoms.InvexaButton
import com.example.designsystem.components.atoms.InvexaDropdown
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
fun WarehouseOnboardingScreen(
    onFinishSetupClick: () -> Unit,
    onSkipClick: () -> Unit,
    onBack: () -> Unit
){
    var warehouseNameValue by remember { mutableStateOf("") }
    var locationValue by remember { mutableStateOf("") }
    var warehouseType by remember { mutableStateOf("General Storage") }

    val warehouseTypeList = listOf("General Storage", "Cold Storage", "Electronics", "Pharmacy")

    WarehouseOnboardingContent(
        warehouseNameValue = warehouseNameValue,
        onWarehouseNameChange = { warehouseNameValue = it },
        locationValue = locationValue,
        onLocationChange = { locationValue = it },
        warehouseType = warehouseType,
        onWarehouseTypeChange = { warehouseType = it },
        warehouseTypeList = warehouseTypeList,
        onFinishSetupClick = onFinishSetupClick,
        onSkipClick = onSkipClick,
        onBack = onBack
    )
}

@Composable
fun WarehouseOnboardingContent(
    warehouseNameValue: String,
    onWarehouseNameChange: (String) -> Unit,
    locationValue: String,
    onLocationChange: (String) -> Unit,
    warehouseType: String,
    onWarehouseTypeChange: (String) -> Unit,
    warehouseTypeList: List<String>,
    onFinishSetupClick: () -> Unit,
    onSkipClick: () -> Unit,
    onBack: () -> Unit
) {
    val scrollState = rememberScrollState()

    val typography = MaterialTheme.typography
    val colors = MaterialTheme.colorScheme
    val extend = MaterialTheme.invexaColors

    Scaffold(
        topBar = {
            InvexaAppBar(
                onBackClick = onBack
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(horizontal = Spacing.space450, vertical = Spacing.space600)
                .verticalScroll(scrollState),
        ) {
            InvexaStepProgressBar(totalSteps = 2, currentStep = 2)
            Spacer(modifier = Modifier.height(Spacing.space450))

            Text(
                text = stringResource(R.string.warehouse_onboarding_title),
                style = typography.titleLarge
            )
            Spacer(modifier = Modifier.height(Spacing.space100))
            Text(
                text = stringResource(R.string.warehouse_onboarding_description),
                style = typography.bodySmall,
                color = colors.onSurfaceVariant
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth().padding(vertical = Spacing.space300),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                InvexaTextField(
                    value = warehouseNameValue,
                    onValueChange = onWarehouseNameChange,
                    label = stringResource(id = R.string.warehouse_name_label),
                    leadingIcon = InvexaIcons.Company,
                    placeholder = stringResource(id = R.string.warehouse_name_placeholder)
                )
                Spacer(modifier = Modifier.height(Spacing.space200))
                InvexaTextField(
                    value = locationValue,
                    onValueChange = onLocationChange,
                    label = stringResource(id = R.string.location_label),
                    leadingIcon = InvexaIcons.Username,
                    placeholder = stringResource(id = R.string.location_placeholder)
                )
                Spacer(modifier = Modifier.height(Spacing.space300))
                InvexaDropdown(
                    label = stringResource(R.string.warehouse_type_label),
                    options = warehouseTypeList,
                    selected = warehouseType,
                    onSelected = onWarehouseTypeChange,
                )
                Spacer(modifier = Modifier.height(Spacing.space300))
                InvexaButton(
                    onClick = onFinishSetupClick,
                    text = stringResource(id = R.string.finish_setup_button),
                    modifier = Modifier.fillMaxWidth(),
                    size = ButtonSize.Large,
                )
                InvexaTextButton(
                    text = stringResource(id = R.string.skip_for_now),
                    onClick = onSkipClick,
                )
                Text(
                    text = stringResource(id = R.string.warehouse_onboarding_hint),
                    color = extend.textTertiary.copy(alpha = 0.8f),
                    style = typography.bodySmall,
                )
            }
        }
    }
}