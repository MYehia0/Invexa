package com.example.presentation.home.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.designsystem.components.molecules.InvexaCard
import com.example.designsystem.components.molecules.InvexaEmptyState
import com.example.designsystem.components.molecules.InvexaHeader
import com.example.designsystem.components.molecules.InvexaIconBox
import com.example.designsystem.components.molecules.InvexaStatusCard
import com.example.designsystem.icons.InvexaIcons
import com.example.designsystem.theme.invexaColors
import com.example.designsystem.tokens.component.CardStatusTone
import com.example.designsystem.tokens.raw.Spacing
import com.example.designsystem.tokens.semantic.SemanticShapes
import com.example.presentation.R
import com.example.presentation.home.composables.AuditListRow
import com.example.presentation.home.composables.AuditModelUI

data class DashboardItemsModelUI(
    val title: String,
    val num: Int,
    val tone: CardStatusTone,
    val icon: ImageVector,
)

data class QuickActionsModelUI(
    val title: String,
    val icon: ImageVector,
    val onClick: () -> Unit
)

@Composable
fun DashboardScreen (
    userName: String,
    noAudits: Boolean,
    dashboardItems :List<DashboardItemsModelUI>? = null,
    quickActions: List<QuickActionsModelUI>? = null,
    lastAudits: List<AuditModelUI>? = null,
    onClickNoAudits: (() -> Unit)? = null
) {
    DashboardScreenContent(
        userName = userName,
        noAudits = noAudits,
        dashboardItems = dashboardItems,
        quickActions = quickActions,
        lastAudits = lastAudits,
        onClickNoAudits = onClickNoAudits
    )
}

@Composable
private fun DashboardScreenContent (
    userName: String,
    noAudits: Boolean,
    dashboardItems :List<DashboardItemsModelUI>? = null,
    quickActions: List<QuickActionsModelUI>? = null,
    lastAudits: List<AuditModelUI>? = null,
    onClickNoAudits: (() -> Unit)? = null
) {
    val scrollState = rememberScrollState()
    val colors = MaterialTheme.colorScheme

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colors.background)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DashboardHeader(userName)
        if(noAudits && onClickNoAudits != null)
            NoAuditsCard(onClick = onClickNoAudits)
        else if(dashboardItems != null && quickActions != null && lastAudits != null)
            Dashboard(
                dashboardItems = dashboardItems,
                quickActions = quickActions,
                lastAudits = lastAudits
            )
    }
}

@Composable
private fun DashboardHeader (userName: String) {
    val typography = MaterialTheme.typography
    val colors = MaterialTheme.colorScheme

    InvexaHeader(
        alignment = Alignment.BottomStart
    ) {
        InvexaHeader(alignment = Alignment.BottomStart) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Spacing.space450, vertical = Spacing.space600),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Column(
                    Modifier
                        .weight(1f)
                ) {
                    Text(
                        text = "Good morning, $userName 👋",
                        style = typography.titleMedium,
                        color = colors.onPrimary,
                    )
                    Spacer(modifier = Modifier.height(Spacing.space100))
                    Text(
                        text = stringResource(R.string.dashboard_subtitle),
                        style = typography.bodySmall,
                        color = colors.onPrimary.copy(alpha = 0.85f),
                    )
                }
                Box(
                    modifier = Modifier
                        .size(56.dp)
                        .background(colors.onPrimary.copy(alpha = 0.15f), RoundedCornerShape(SemanticShapes.shapeMD)),
                    contentAlignment = Alignment.Center,
                ) {
                    Icon(InvexaIcons.Sessions, contentDescription = null, tint = colors.onPrimary)
                }
            }
        }
    }

}

@Composable
private fun Dashboard(
    dashboardItems :List<DashboardItemsModelUI>,
    quickActions: List<QuickActionsModelUI>,
    lastAudits: List<AuditModelUI>,
) {
    val extended = MaterialTheme.invexaColors
    val typography = MaterialTheme.typography

    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier.padding(Spacing.space450),
            verticalArrangement = Arrangement.spacedBy(Spacing.space300)
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(Spacing.space300)) {
                dashboardItems.take(2).forEach {
                    InvexaStatusCard(
                        modifier = Modifier.weight(1f),
                        icon = it.icon,
                        label = it.title,
                        value = it.num.toString(),
                        tone = it.tone
                    )
                }
            }
            Row(horizontalArrangement = Arrangement.spacedBy(Spacing.space300)) {
                dashboardItems.drop(2).take(2).forEach {
                    InvexaStatusCard(
                        modifier = Modifier.weight(1f),
                        icon = it.icon,
                        label = it.title,
                        value = it.num.toString(),
                        tone = it.tone
                    )
                }
            }
        }

        Text(
            text = stringResource(R.string.quick_actions),
            color = extended.textPrimary,
            textAlign = TextAlign.Center,
            style = typography.titleMedium,
            modifier = Modifier.padding(horizontal = Spacing.space400)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(horizontal = Spacing.space450, vertical = Spacing.space200),
            horizontalArrangement = Arrangement.spacedBy(Spacing.space200)
        ) {
            val cardModifier = Modifier.width(90.dp).height(90.dp)
            quickActions.forEach {
                QuickActionsCard(
                    text = it.title,
                    icon = it.icon,
                    modifier = cardModifier,
                    onClick = it.onClick
                )
            }
        }
        Spacer(Modifier.height(Spacing.space200))
        Text(
            text = stringResource(R.string.last_activity),
            color = extended.textPrimary,
            textAlign = TextAlign.Center,
            style = typography.titleMedium,
            modifier = Modifier.padding(horizontal = Spacing.space400)
        )

        Column(
            modifier = Modifier
                .padding(horizontal = Spacing.space450, Spacing.space200),
            verticalArrangement = Arrangement.spacedBy(Spacing.space200)
        ) {
            lastAudits.forEach {
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
        Spacer(Modifier.height(Spacing.space800))
    }
}

@Composable
private fun QuickActionsCard(
    modifier: Modifier = Modifier,
    text: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    val colors = MaterialTheme.colorScheme
    val extended = MaterialTheme.invexaColors
    val typography = MaterialTheme.typography

    InvexaCard (
        modifier = modifier,
        onClick = onClick,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        InvexaIconBox(
            icon = icon,
            iconTint =  colors.primary,
            boxSize = 30.dp
        )
        Spacer(Modifier.height(Spacing.space100))
        Text(
            text = text,
            color = extended.textPrimary,
            textAlign = TextAlign.Center,
            style = typography.labelSmall,
        )
    }
}

@Composable
private fun NoAuditsCard(onClick: () -> Unit) {
    InvexaCard (
        modifier = Modifier.padding(horizontal = Spacing.space450, vertical = Spacing.space600)
    ) {
        InvexaEmptyState(
            icon = InvexaIcons.FactCheck,
            title = stringResource(R.string.no_audits_title),
            description = stringResource(R.string.no_audits_description),
            buttonText = stringResource(R.string.create_your_first_audit_button),
            onButtonClick = onClick
        )
    }
}