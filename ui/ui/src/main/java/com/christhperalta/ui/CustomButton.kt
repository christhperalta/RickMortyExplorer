package com.christhperalta.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    onClick : () -> Unit,
    content : @Composable () -> Unit
) {

    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth()
    ) {
        content()
    }
}

