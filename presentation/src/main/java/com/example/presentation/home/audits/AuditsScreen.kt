package com.example.presentation.home.audits

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
import com.example.designsystem.components.molecules.InvexaSearchBar
import com.example.designsystem.icons.InvexaIcons
import com.example.designsystem.tokens.component.ButtonSize
import com.example.designsystem.tokens.raw.Spacing
import com.example.presentation.R
import com.example.presentation.home.composables.AuditListRow
import com.example.presentation.home.composables.AuditModelUI

@Composable
fun AuditScreen (
    audits: List<AuditModelUI>,
    onClickNew: ()-> Unit,
) {
    var searchQuery by remember { mutableStateOf("") }

    AuditScreenContent(
        audits = audits,
        searchQuery = searchQuery,
        onQueryChange = {searchQuery = it},
        onClickNew = onClickNew,
    )
}

@Composable
fun AuditScreenContent (
    audits: List<AuditModelUI>,
    searchQuery: String,
    onQueryChange: (String) -> Unit,
    onClickNew: () -> Unit
) {
    val colors = MaterialTheme.colorScheme

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(colors.background)
            .padding(start = Spacing.space400, end = Spacing.space400, top = Spacing.space300, bottom = Spacing.space800),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            AuditHeader(onClickNew = onClickNew)
        }
        item {
            InvexaSearchBar(
                query = searchQuery,
                placeholder = stringResource(R.string.search_audit_sessions),
                onQueryChange = onQueryChange,
            )
        }
        items(audits) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = Spacing.space300)
            ) {
                AuditListRow(
                    title = it.title,
                    subtitle = it.subtitle,
                    badge = it.badge,
                    status = it.status,
                    icon = it.icon,
                    onClick = it.onClick
                )
            }
        }
    }
}

@Composable
private fun AuditHeader (
    onClickNew: () -> Unit
) {
    val typography = MaterialTheme.typography
    val colors = MaterialTheme.colorScheme

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = Spacing.space200),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            Modifier
                .weight(1f)
        ) {
            Text(
                text = stringResource(R.string.audit_sessions),
                style = typography.titleSmall
            )
            Text(
                text = stringResource(R.string.track_progress_across_every_warehouse_audit),
                style = typography.bodySmall,
                color = colors.onSurfaceVariant
            )
        }
        InvexaButton(
            leadingIcon = InvexaIcons.Add,
            text = stringResource(R.string.new_button),
            size = ButtonSize.Small,
            onClick = onClickNew
        )
    }
}