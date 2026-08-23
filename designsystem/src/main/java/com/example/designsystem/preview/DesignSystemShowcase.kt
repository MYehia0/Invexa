package com.example.designsystem.preview

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SearchOff
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.designsystem.components.atoms.InvexaAvatar
import com.example.designsystem.components.atoms.InvexaBadge
import com.example.designsystem.components.atoms.InvexaButton
import com.example.designsystem.components.atoms.InvexaCheckbox
import com.example.designsystem.components.atoms.InvexaChip
import com.example.designsystem.components.atoms.InvexaDangerButton
import com.example.designsystem.components.atoms.InvexaOutlinedButton
import com.example.designsystem.components.atoms.InvexaSwitch
import com.example.designsystem.components.atoms.InvexaTextButton
import com.example.designsystem.components.atoms.InvexaTextField
import com.example.designsystem.components.molecules.InvexaCard
import com.example.designsystem.components.molecules.InvexaEmptyState
import com.example.designsystem.components.molecules.InvexaListRow
import com.example.designsystem.components.molecules.InvexaProgressBar
import com.example.designsystem.components.molecules.InvexaSearchBar
import com.example.designsystem.components.molecules.InvexaSkeletonListRow
import com.example.designsystem.components.molecules.InvexaStatusCard
import com.example.designsystem.components.organisms.InvexaAppBar
import com.example.designsystem.icons.InvexaIcons
import com.example.designsystem.theme.InvexaTheme
import com.example.designsystem.theme.invexaColors
import com.example.designsystem.tokens.component.AvatarSize
import com.example.designsystem.tokens.component.BadgeTone
import com.example.designsystem.tokens.raw.Spacing

@Composable
fun Screen() {
    InvexaTheme(
        darkTheme = false
    ) {
        var chipIndex by remember { mutableStateOf(0) }
        var fieldValue by remember { mutableStateOf("") }
        var searchQuery by remember { mutableStateOf("") }
        var switchOn by remember { mutableStateOf(true) }
        var checkboxOn by remember { mutableStateOf(false) }

        val chips = listOf("All", "Low Stock", "Completed", "Flagged")

        Scaffold(
            topBar = { InvexaAppBar(title = "Design System") },
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {
                LazyColumn(
                    contentPadding = PaddingValues(Spacing.space400),
                    verticalArrangement = Arrangement.spacedBy(Spacing.space600),
                    modifier = Modifier.weight(1f),
                ){

                    item { SectionLabel("Buttons") }
                    item {
                        Column(verticalArrangement = Arrangement.spacedBy(Spacing.space300)) {
                            InvexaButton(text = "Primary Button", onClick = {})
                            InvexaButton(text = "Loading", onClick = {}, isLoading = true)
                            InvexaButton(text = "Disabled", onClick = {}, enabled = false)
                            InvexaOutlinedButton(text = "Outlined Button", onClick = {})
                            InvexaDangerButton(text = "Delete Audit", onClick = {})
                            InvexaTextButton(text = "Text Button", onClick = {})
                        }
                    }

                    item { SectionLabel("Chips & Badges") }
                    item {
                        Row(horizontalArrangement = Arrangement.spacedBy(Spacing.space200)) {
                            chips.forEachIndexed { index, label ->
                                InvexaChip(label = label, selected = index == chipIndex, onClick = { chipIndex = index })
                            }
                        }
                    }
                    item {
                        Row(horizontalArrangement = Arrangement.spacedBy(Spacing.space200)) {
                            InvexaBadge(label = "In Stock", tone = BadgeTone.Success)
                            InvexaBadge(label = "Low Stock", tone = BadgeTone.Warning)
                            InvexaBadge(label = "Out of Stock", tone = BadgeTone.Error)
                            InvexaBadge(label = "In Progress", tone = BadgeTone.Primary)
                        }
                    }

                    item { SectionLabel("Inputs") }
                    item {
                        Column(verticalArrangement = Arrangement.spacedBy(Spacing.space300)) {
                            InvexaTextField(value = fieldValue, onValueChange = { fieldValue = it }, label = "Email", placeholder = "you@company.com")
                            InvexaTextField(value = "", onValueChange = {}, label = "Password", isPassword = true, helperText = "At least 8 characters")
                            InvexaTextField(value = "", onValueChange = {}, label = "SKU", errorText = "This field is required")
                            InvexaSearchBar(query = searchQuery, onQueryChange = { searchQuery = it }, placeholder = "Search products")
                        }
                    }

                    item { SectionLabel("Selection Controls") }
                    item {
                        Column(verticalArrangement = Arrangement.spacedBy(Spacing.space300)) {
                            Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                                Text("Enable AI Insights", modifier = Modifier.weight(1f))
                                InvexaSwitch(checked = switchOn, onCheckedChange = { switchOn = it })
                            }
                            InvexaCheckbox(label = "Remember me", checked = checkboxOn, onCheckedChange = { checkboxOn = it })
                        }
                    }

                    item { SectionLabel("Avatars") }
                    item {
                        Row(horizontalArrangement = Arrangement.spacedBy(Spacing.space300)) {
                            InvexaAvatar(initialsText = "MA", size = AvatarSize.Small)
                            InvexaAvatar(initialsText = "MA", size = AvatarSize.Medium)
                            InvexaAvatar(initialsText = "MA", size = AvatarSize.Large, showCameraBadge = true)
                        }
                    }

                    item { SectionLabel("Cards") }
                    item {
                        Row(horizontalArrangement = Arrangement.spacedBy(Spacing.space300)) {
                            InvexaStatusCard(
                                modifier = Modifier.weight(1f),
                                icon = InvexaIcons.Sessions,
                                value = "128",
                                label = "Items Audited",
                                progressFraction = 0.72f,
                            )
                            InvexaStatusCard(
                                modifier = Modifier.weight(1f),
                                icon = InvexaIcons.Warning,
                                value = "6",
                                label = "Discrepancies",
                                progressFraction = 0.2f,
                            )
                        }
                    }
                    item {
                        InvexaCard(modifier = Modifier.fillMaxWidth()) {
                            Text("Audit Summary", color = MaterialTheme.colorScheme.onSurface)
                            Text("94% match rate across 128 scanned items.")
                        }
                    }

                    item { SectionLabel("List Rows") }
                    item {
                        Column {
                            InvexaListRow(
                                leading = {Icon(InvexaIcons.Sessions, contentDescription = null, tint = MaterialTheme.invexaColors.iconDefault)},
                                title = "Warehouse A — Q3 Audit",
                                subtitle = "128 items · 94% complete",
                                onClick = {},
                                trailing = { InvexaBadge(label = "In Progress", tone = BadgeTone.Primary, showDot = false) },
                            )
                            InvexaListRow(
                                leading = {Icon(InvexaIcons.Reports, contentDescription = null, tint = MaterialTheme.invexaColors.iconDefault)},
                                title = "Monthly Report — August",
                                subtitle = "Generated Aug 1, 2026",
                                onClick = {},
                            )
                        }
                    }

                    item { SectionLabel("Progress") }
                    item { InvexaProgressBar(fraction = 0.65f) }

                    item { SectionLabel("Skeleton Loading") }
                    item { InvexaSkeletonListRow() }

                    item { SectionLabel("Empty State") }
                    item {
                        InvexaEmptyState(
                            icon = Icons.Filled.SearchOff,
                            title = "No results found",
                            description = "Try adjusting your filters or search terms.",
                            buttonText = "Clear filters",
                            onButtonClick = {},
                        )
                    }
                }
            }

        }
    }
}

@Composable
private fun SectionLabel(text: String) {
    Text(text = text, style = MaterialTheme.typography.titleSmall, color = MaterialTheme.colorScheme.onSurface)
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun ScreenPreview (){
    Screen()
}