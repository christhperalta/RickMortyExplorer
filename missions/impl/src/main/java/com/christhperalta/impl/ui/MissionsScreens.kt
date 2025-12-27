package com.christhperalta.impl.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.christhperalta.ui.CustomTopAppBar

@Composable
fun MissionsScreens() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { CustomTopAppBar(title = "Missions", accionButton = false) {} }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {

        }
    }
}

@Preview(name = "MissionsScreens")
@Composable
private fun PreviewMissionsScreens() {
    MissionsScreens()
}