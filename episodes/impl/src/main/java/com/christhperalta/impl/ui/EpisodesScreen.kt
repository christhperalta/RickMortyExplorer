package com.christhperalta.impl.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun EpisodesScreen(
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        Text(text = "EpisodesScreen")
    }
}

@Preview(name = "EpisodesScreen")
@Composable
private fun PreviewEpisodesScreen() {
    EpisodesScreen()
}