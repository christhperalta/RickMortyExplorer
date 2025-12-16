package com.christhperalta.impl.ui.character_list

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import com.christhperalta.ui.CustomCharacterCard
import com.christhperalta.ui.CustomSearchFilter
import com.christhperalta.ui.CustomText
import com.christhperalta.ui.CustomTopAppBar
import com.christhperalta.ui.R
import kotlinx.coroutines.launch

@Composable
fun CharactersListScreen(
    onCharacterDetailsClicked: (Int) -> Unit,
    onBack: () -> Unit,
    viewModel: CharacterListViewModel = hiltViewModel()
) {


    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val coroutineScope = rememberCoroutineScope()
    val gridState = rememberLazyGridState()
    val showScrollToTop by remember {
        derivedStateOf {
            gridState.firstVisibleItemIndex > 8
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Column {
                CustomTopAppBar(title = "Characters", accionButton = false, onClick = onBack)
                CustomSearchFilter(
                    onSearchTextChange = viewModel::filterCharactersByName,
                    onStatusChange = viewModel::updateStatusFilter
                )
            }
        },
        floatingActionButton = {
            if (showScrollToTop) {
                FloatingActionButton(onClick = {
                    coroutineScope.launch {
                        gridState.animateScrollToItem(0)
                    }
                }) {
                    Icon(
                        painter = painterResource(R.drawable.arrow_drop_up),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.secondary
                    )
                }
            }
        }
    ) { innerPadding ->

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
                items(uiState.characters.size) { index ->
                    val character = uiState.characters[index]
                    CustomCharacterCard(
                        name = character.name,
                        status = character.status,
                        species = character.species,
                        imageUrl = character.image,
                        onCharacterClicked = { onCharacterDetailsClicked(character.id) }
                    )
                }


            }
        }
    }
}
