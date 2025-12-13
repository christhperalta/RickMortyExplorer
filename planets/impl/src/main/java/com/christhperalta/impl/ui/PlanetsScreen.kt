package com.christhperalta.impl.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PlanetsScreen(
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        Text(text = "PlanetsScreen")
    }
}

@Preview(name = "PlanetsScreen")
@Composable
private fun PreviewPlanetsScreen() {
    PlanetsScreen()
}