package com.christhperalta.ui

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


enum class CharacterStatus(val label: String) {
    ALL("All"),
    ALIVE("Alive"),
    DEAD("Dead"),
    UNKNOWN("Unknown")
}

@Composable
fun CustomSearchFilter(
    onSearchTextChange: (String) -> Unit,
    onStatusChange: (String) -> Unit
) {

    var searchText by remember { mutableStateOf("") }
    var selectedStatus by remember { mutableStateOf(CharacterStatus.ALL) }

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {
        OutlinedTextField(
            value = searchText,
            onValueChange = { newText ->
                searchText = newText
                onSearchTextChange(newText)
            },
            placeholder = { CustomText(text = "Search character...") },
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.search_24px),
                    contentDescription = "Search"
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = MaterialTheme.colorScheme.secondary,
                unfocusedBorderColor = MaterialTheme.colorScheme.secondary
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomText(text = "Filter by State:", style = MaterialTheme.typography.titleMedium)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CharacterStatus.entries.forEach { status ->
                FilterChip(
                    selected = selectedStatus == status,
                    onClick = {
                        val newStatus =
                            if (selectedStatus == status) CharacterStatus.ALL else status
                        selectedStatus = newStatus
                        val statusValue =
                            if (newStatus == CharacterStatus.ALL) "" else newStatus.name.lowercase()

                        onStatusChange(statusValue)
                    },
                    label = { CustomText(text = status.label) }
                )
            }
        }
    }
}