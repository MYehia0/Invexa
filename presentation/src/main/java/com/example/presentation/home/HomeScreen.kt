package com.example.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.designsystem.components.organisms.BottomNavItem
import com.example.designsystem.components.organisms.InvexaAppBar
import com.example.designsystem.components.organisms.InvexaBottomNav
import com.example.designsystem.components.organisms.InvexaCenterFab
import com.example.designsystem.icons.InvexaIcons
import com.example.designsystem.theme.invexaColors
import com.example.designsystem.tokens.component.CardStatusTone
import com.example.presentation.R
import com.example.presentation.home.audits.AuditScreen
import com.example.presentation.home.composables.AuditModelUI
import com.example.presentation.home.composables.AuditStatusTone
import com.example.presentation.home.dashboard.DashboardItemsModelUI
import com.example.presentation.home.dashboard.DashboardScreen
import com.example.presentation.home.dashboard.QuickActionsModelUI

@Composable
fun HomeScreen (
    onStartScanning: ()-> Unit
) {
    var navIndex by remember { mutableIntStateOf(0) }

    HomeScreenContent(
        navIndex = navIndex,
        onNavItemSelected = { navIndex = it },
        onStartScanning = onStartScanning
    )
}

@Composable
private fun HomeScreenContent (
    navIndex: Int,
    onNavItemSelected: (Int) -> Unit,
    onStartScanning: ()-> Unit
) {
    val typography = MaterialTheme.typography
    val extend = MaterialTheme.invexaColors
    val colors = MaterialTheme.colorScheme
    val extended = MaterialTheme.invexaColors

    Scaffold(
        topBar = {
            InvexaAppBar(
                titleComponent = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(
                                if (navIndex == 0) {
                                    R.drawable.ic_logo_home
                                }
                                else {
                                    R.drawable.ic_logo_full
                                }
                            ),
                            contentDescription = null,
                            modifier = Modifier.size(48.dp)
                        )
                        Text(
                            text = stringResource(id = R.string.app_name),
                            color = if (navIndex == 0) Color.White else extended.textPrimary,
                            style = typography.titleMedium,
                        )
                    }
                },
                containerColor = if (navIndex == 0) extend.appBarHome else colors.surface,
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = InvexaIcons.Settings,
                            contentDescription = null,
                            tint = if (navIndex == 0) Color.White else extended.textPrimary
                        )
                    }
                },
            )
        },
        bottomBar = {
            InvexaBottomNav(
                items = listOf(
                    BottomNavItem(stringResource(R.string.home), InvexaIcons.Home),
                    BottomNavItem(stringResource(R.string.audits), InvexaIcons.Sessions),
                ),
                selectedIndex = navIndex,
                onItemSelected = onNavItemSelected,
            )
        },
        floatingActionButton = {
            InvexaCenterFab(
                icon = InvexaIcons.Scan,
                onFabClick = onStartScanning,
            )
        },
        floatingActionButtonPosition = FabPosition.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(it)
        ) {
            if (navIndex == 0) {
                DashboardScreen(
                    userName = "Mohamed",
                    noAudits = false,
                    dashboardItems = listOf(
                        DashboardItemsModelUI(
                            title = stringResource(R.string.active_audits),
                            num = 7,
                            icon = InvexaIcons.Sessions,
                            tone = CardStatusTone.Primary
                        ),
                        DashboardItemsModelUI(
                            title = stringResource(R.string.completed),
                            num = 24,
                            icon = InvexaIcons.Check,
                            tone = CardStatusTone.Success
                        ),
                        DashboardItemsModelUI(
                            title = stringResource(R.string.pending_sync),
                            num = 5,
                            icon = InvexaIcons.Pending,
                            tone = CardStatusTone.Warning
                        ),
                        DashboardItemsModelUI(
                            title = stringResource(R.string.scanned_today),
                            num = 1248,
                            icon = InvexaIcons.QrCodeScanner,
                            tone = CardStatusTone.Primary
                        ),
                    ),
                    quickActions = listOf(
                        QuickActionsModelUI(
                            title = stringResource(R.string.new_audit),
                            icon = InvexaIcons.Add,
                            onClick = {}
                        ),
                        QuickActionsModelUI(
                            title = stringResource(R.string.continue_audit),
                            icon = InvexaIcons.Continue,
                            onClick = {}
                        )
                    ),
                    lastAudits = listOf(
                        AuditModelUI(
                            title = stringResource(R.string.main_warehouse_audit),
                            subtitle = stringResource(R.string.main_warehouse),
                            badge = stringResource(R.string.in_progress),
                            icon = InvexaIcons.Sessions,
                            status = AuditStatusTone.Progress,
                            onClick = {}
                        ),
                        AuditModelUI(
                            title = stringResource(R.string.electronics_warehouse_audit),
                            subtitle = stringResource(R.string.electronics_warehouse),
                            badge = stringResource(R.string.completed),
                            status = AuditStatusTone.Completed,
                            icon = InvexaIcons.Check,
                            onClick = {}
                        )
                    ),
                    onClickNoAudits = {}
                )
            }
            else if (navIndex == 1) {
                AuditScreen(
                    audits = listOf(
                        AuditModelUI(
                            title = stringResource(R.string.main_warehouse_audit),
                            subtitle = stringResource(R.string.main_warehouse),
                            badge = stringResource(R.string.in_progress),
                            icon = InvexaIcons.Sessions,
                            status = AuditStatusTone.Progress,
                            onClick = {}
                        ),
                        AuditModelUI(
                            title = stringResource(R.string.electronics_warehouse_audit),
                            subtitle = stringResource(R.string.electronics_warehouse),
                            badge = stringResource(R.string.completed),
                            status = AuditStatusTone.Completed,
                            icon = InvexaIcons.Check,
                            onClick = {}
                        ),
                        AuditModelUI(
                            title = stringResource(R.string.main_warehouse_audit),
                            subtitle = stringResource(R.string.main_warehouse),
                            badge = stringResource(R.string.in_progress),
                            icon = InvexaIcons.Sessions,
                            status = AuditStatusTone.Progress,
                            onClick = {}
                        ),
                        AuditModelUI(
                            title = stringResource(R.string.electronics_warehouse_audit),
                            subtitle = stringResource(R.string.electronics_warehouse),
                            badge = stringResource(R.string.completed),
                            status = AuditStatusTone.Completed,
                            icon = InvexaIcons.Check,
                            onClick = {}
                        ),
                        AuditModelUI(
                            title = stringResource(R.string.main_warehouse_audit),
                            subtitle = stringResource(R.string.main_warehouse),
                            badge = stringResource(R.string.in_progress),
                            icon = InvexaIcons.Sessions,
                            status = AuditStatusTone.Progress,
                            onClick = {}
                        ),
                        AuditModelUI(
                            title = stringResource(R.string.electronics_warehouse_audit),
                            subtitle = stringResource(R.string.electronics_warehouse),
                            badge = stringResource(R.string.completed),
                            status = AuditStatusTone.Completed,
                            icon = InvexaIcons.Check,
                            onClick = {}
                        ),
                        AuditModelUI(
                            title = stringResource(R.string.main_warehouse_audit),
                            subtitle = stringResource(R.string.main_warehouse),
                            badge = stringResource(R.string.in_progress),
                            icon = InvexaIcons.Sessions,
                            status = AuditStatusTone.Progress,
                            onClick = {}
                        ),
                        AuditModelUI(
                            title = stringResource(R.string.electronics_warehouse_audit),
                            subtitle = stringResource(R.string.electronics_warehouse),
                            badge = stringResource(R.string.completed),
                            status = AuditStatusTone.Completed,
                            icon = InvexaIcons.Check,
                            onClick = {}
                        ),
                        AuditModelUI(
                            title = stringResource(R.string.main_warehouse_audit),
                            subtitle = stringResource(R.string.main_warehouse),
                            badge = stringResource(R.string.in_progress),
                            icon = InvexaIcons.Sessions,
                            status = AuditStatusTone.Progress,
                            onClick = {}
                        ),
                        AuditModelUI(
                            title = stringResource(R.string.electronics_warehouse_audit),
                            subtitle = stringResource(R.string.electronics_warehouse),
                            badge = stringResource(R.string.completed),
                            status = AuditStatusTone.Completed,
                            icon = InvexaIcons.Check,
                            onClick = {}
                        ),
                        AuditModelUI(
                            title = stringResource(R.string.main_warehouse_audit),
                            subtitle = stringResource(R.string.main_warehouse),
                            badge = stringResource(R.string.in_progress),
                            icon = InvexaIcons.Sessions,
                            status = AuditStatusTone.Progress,
                            onClick = {}
                        ),
                        AuditModelUI(
                            title = stringResource(R.string.electronics_warehouse_audit),
                            subtitle = stringResource(R.string.electronics_warehouse),
                            badge = stringResource(R.string.completed),
                            status = AuditStatusTone.Completed,
                            icon = InvexaIcons.Check,
                            onClick = {}
                        ),
                    ),
                    onClickNew = {}
                )
            }
        }
    }
}