package com.christhperalta.impl.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.christhperalta.ui.CustomCharacterCard
import com.christhperalta.ui.CustomSearchFilter
import com.christhperalta.ui.CustomTopAppBar

@Composable
fun CollectionScreen(
    viewModel: CollectionScreenViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val coroutineScope = rememberCoroutineScope()
    val gridState = rememberLazyGridState()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Column {
                CustomTopAppBar(title = "Collection", accionButton = false){}
                CustomSearchFilter(
                    onSearchTextChange = {},
                    onStatusChange = {}
                )
            }
        }
    ) {innerPadding ->
        if (uiState.isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    color = MaterialTheme.colorScheme.secondary

                )
            }
        } else {


                LazyVerticalGrid(
                    modifier = Modifier
                        .padding(innerPadding)
                        .padding(horizontal = 16.dp),
                    state = gridState,
                    columns = GridCells.Adaptive(170.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(uiState.favoriteCharacters.size) { index ->
                        val character = uiState.favoriteCharacters[index]
                        CustomCharacterCard(
                            name = character.name,
                            status = character.status,
                            species = character.species,
                            imageUrl = character.image,
                            onCharacterClicked = {  },
//                            onCharacterDetailsClicked(character.id)
                        )
                    }



                }
            }
        }

    }



@Preview(name = "CollectionScreen")
@Composable
private fun PreviewCollectionScreen() {
    CollectionScreen()
}