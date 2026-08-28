package com.example.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.designsystem.components.organisms.BottomNavItem
import com.example.designsystem.components.organisms.InvexaBottomNav
import com.example.designsystem.components.organisms.InvexaCenterFab
import com.example.designsystem.icons.InvexaIcons
import com.example.presentation.home.audits.AuditScreen
import com.example.presentation.home.dashboard.DashboardScreen

@Composable
fun HomeScreen () {
    var navIndex by remember { mutableIntStateOf(0) }

    HomeScreenContent(
        navIndex = navIndex,
        onNavItemSelected = { navIndex = it }
    )
}

@Composable
private fun HomeScreenContent (
    navIndex: Int,
    onNavItemSelected: (Int) -> Unit
) {

    Scaffold(
        bottomBar = {
            InvexaBottomNav(
                items = listOf(
                    BottomNavItem("Home", InvexaIcons.Dashboard),
                    BottomNavItem("Sessions", InvexaIcons.Sessions),
//                    BottomNavItem("Reports", InvexaIcons.Reports),
//                    BottomNavItem("Settings", InvexaIcons.Settings),
                ),
                selectedIndex = navIndex,
                onItemSelected = onNavItemSelected,
            )
        },
        floatingActionButton = {
            InvexaCenterFab(
                icon = InvexaIcons.Scan,
                onFabClick = {},
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
                DashboardScreen()
            }
            else if (navIndex == 1) {
                AuditScreen()
            }
        }
    }
}