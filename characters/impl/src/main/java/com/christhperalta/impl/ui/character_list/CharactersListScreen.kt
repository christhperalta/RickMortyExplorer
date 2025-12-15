package com.christhperalta.impl.ui.character_list

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import com.christhperalta.impl.R
import com.christhperalta.ui.CustomText
import com.christhperalta.ui.CustomTopAppBar

@Composable
fun CharactersListScreen(
    onCharacterDetailsClicked: (String) -> Unit,
    onBack: () -> Unit,
    viewModel: CharacterListViewModel = hiltViewModel()
) {


    val uiState by viewModel.uiState.collectAsStateWithLifecycle()


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CustomTopAppBar(title = "Characters", accionButton = false, onClick = onBack)
        }) { innerPadding ->
        LazyVerticalGrid(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            if (uiState.isLoading) {
                item(
                    span = { GridItemSpan(maxLineSpan) }
                ) {
                    CircularProgressIndicator()
                }
            } else {
                items(uiState.characters.size) { index ->
                    val character = uiState.characters[index]
                    CharacterCard(
                        name = character.name,
                        status = character.status,
                        species = character.species,
                        imageUrl = character.image,
                        modifier = Modifier
                    )
                }
            }

        }
    }
}

@Composable
fun CharacterCard(
    name: String,
    status: String,
    species: String,
    imageUrl : String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.height(300.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
    ) {
        Column(
            modifier = modifier
                .fillMaxHeight()
        ) {
            AsyncImage(
                model = imageUrl,
                contentDescription = name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
//            Image(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(200.dp),
//                contentScale = ContentScale.Crop,
//                painter = painterResource(com.christhperalta.ui.R.drawable.prueba),
//                contentDescription = null,
//            )
            Spacer(modifier = modifier.height(20.dp))
            Column(
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                CustomText(text = name, style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .clip(CircleShape)
                            .background(color = if (status == "Alive") MaterialTheme.colorScheme.secondaryContainer else MaterialTheme.colorScheme.onError)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CustomText(text = status)
                        Spacer(modifier = Modifier.width(4.dp))
                        CustomText(text = "-")
                        Spacer(modifier = Modifier.width(4.dp))
                        CustomText(text = species)
                    }
                }
            }
        }
    }
}


