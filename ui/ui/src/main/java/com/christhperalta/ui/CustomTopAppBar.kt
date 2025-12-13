package com.christhperalta.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(
    modifier: Modifier = Modifier,
    text: String = "",
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            CustomText(
                text = text,
                style = MaterialTheme.typography.titleLarge
            )
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(painter = painterResource(R.drawable.account), contentDescription = null)
            }
        }
    )

}

@Preview(name = "CustomTopAppBar")
@Composable
private fun PreviewCustomTopAppBar() {
    CustomTopAppBar()
}