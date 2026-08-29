package com.example.presentation.audit.newaudit

import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.designsystem.theme.invexaColors


//NewAuditScreen

@Composable
fun NewAuditScreen(
    onCreateAudit: () -> Unit
) {
    var auditNameValue by remember { mutableStateOf("") }
    var warehouseType by remember { mutableStateOf("General Storage") }
    var notesValue by remember { mutableStateOf("") }

    val auditTypeList = listOf(
        "Full Inventory Audit",
        "Spot Check Audit",
        "Cycle Count",
        "Discrepancy Investigation"
    )

    NewAuditScreenContent(
        onCreateAudit = onCreateAudit
    )
}

@Composable
private fun NewAuditScreenContent(
    onCreateAudit: () -> Unit
) {
    val scrollState = rememberScrollState()


    val typography = MaterialTheme.typography
    val colors = MaterialTheme.colorScheme
    val extend = MaterialTheme.invexaColors


}