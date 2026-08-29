package com.example.presentation.home.start_scanning

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.designsystem.components.atoms.InvexaOutlinedButton
import com.example.designsystem.components.organisms.InvexaAppBar
import com.example.designsystem.icons.InvexaIcons
import com.example.designsystem.tokens.component.ButtonSize
import com.example.designsystem.tokens.raw.Spacing
import com.example.presentation.R
import com.example.presentation.home.composables.AuditListRow
import com.example.presentation.home.composables.AuditModelUI

@Composable
fun StartScanningScreen (
    sessions: List<AuditModelUI>,
    onClickNew: ()-> Unit,
    onBack: () -> Unit
) {
    StartScanningScreenContent(
        sessions = sessions,
        onClickNew = onClickNew,
        onBack = onBack
    )
}

@Composable
fun StartScanningScreenContent (
    sessions: List<AuditModelUI>,
    onClickNew: () -> Unit,
    onBack: () -> Unit
) {
    val colors = MaterialTheme.colorScheme

    Scaffold(
        topBar = {
            InvexaAppBar(
                onBackClick = onBack
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(colors.background)
                .padding(start = Spacing.space400, end = Spacing.space400, top = Spacing.space300, bottom = Spacing.space800),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                StartScanningHeader()
            }

            items(sessions) { session ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = Spacing.space300)
                ) {
                    AuditListRow(
                        title = session.title,
                        subtitle = session.subtitle,
                        badge = session.badge,
                        status = session.status,
                        icon = session.icon,
                        onClick = session.onClick
                    )
                }
            }

            item {
                InvexaOutlinedButton(
                    leadingIcon = InvexaIcons.Add,
                    text = stringResource(R.string.start_a_new_audit),
                    size = ButtonSize.Large,
                    onClick = onClickNew,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = Spacing.space300)
                )
            }
        }
    }
}

@Composable
private fun StartScanningHeader () {
    val typography = MaterialTheme.typography
    val colors = MaterialTheme.colorScheme

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = Spacing.space200),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(Modifier.fillMaxWidth()) {
            Text(
                text = stringResource(R.string.start_scanning),
                style = typography.titleSmall
            )
            Text(
                text = stringResource(R.string.pick_an_audit_to_continue_scanning_or_start_a_new_one),
                style = typography.bodySmall,
                color = colors.onSurfaceVariant
            )
        }
    }
}
