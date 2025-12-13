package com.christhperalta.impl.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CharactersListScreen(
    onCharacterDetailsClicked : (String) -> Unit
) {
    Scaffold(modifier = Modifier.fillMaxSize()) {innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            Text(text = "CharactersScreen")
            Button(onClick = {onCharacterDetailsClicked("123")}) {
                Text(text = "Ir a Characters Details")
            }
        }
    }
}

//@Preview(name = "CharactersScreen")
//@Composable
//private fun PreviewCharactersScreen() {
//    CharactersScreen()
//}