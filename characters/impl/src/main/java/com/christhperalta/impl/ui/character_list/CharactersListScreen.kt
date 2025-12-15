package com.christhperalta.impl.ui.character_list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel

@Composable
fun CharactersListScreen(
    onCharacterDetailsClicked : (String) -> Unit,
    viewModel: CharacterListViewModel = hiltViewModel()
) {
    Scaffold(modifier = Modifier.fillMaxSize()) {innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(text = "CharactersScreen")
            Button(onClick = {onCharacterDetailsClicked("123")}) {
                Text(text = "Ir a Characters Details")
            }
        }
    }
}
