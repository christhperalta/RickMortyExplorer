package com.christhperalta.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CustomText(
    modifier: Modifier = Modifier,
    text : String,
    style: TextStyle = MaterialTheme.typography.bodyLarge
) {
    Text(
        modifier = modifier,
        text = text,
        style = style
    )
}

@Preview(name = "CustomText")
@Composable
private fun PreviewCustomText() {
    CustomText(text = "hola")
}