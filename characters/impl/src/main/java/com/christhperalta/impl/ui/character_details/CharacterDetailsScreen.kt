package com.christhperalta.impl.ui.character_details

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import com.christhperalta.ui.CustomButton
import com.christhperalta.ui.CustomCard
import com.christhperalta.ui.CustomText
import com.christhperalta.ui.CustomTopAppBar

@Composable
fun CharacterDetailsScreen(
    characterId: Int,
    onBack: () -> Unit,
    viewModel: CharacterDetailsViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    var showMore by remember { mutableStateOf(false) }



    LaunchedEffect({}) {
        viewModel.getCharacterById(characterId)
    }


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CustomTopAppBar(
                title = "Character Details",
                accionButton = false,
                onClick = onBack
            )
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
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(horizontal = 16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Spacer(modifier = Modifier.height(30.dp))
                Card(
                    modifier = Modifier
                        .height(400.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    ),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                    ) {
                        AsyncImage(
                            model = uiState.characters?.image,
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(300.dp)
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Column(
                            modifier = Modifier.padding(horizontal = 16.dp)
                        ) {
                            CustomText(
                                text = uiState.characters?.name ?: "",
                                style = MaterialTheme.typography.titleLarge
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(10.dp)
                                        .clip(CircleShape)
                                        .background(color = if (uiState.characters?.status == "Alive") MaterialTheme.colorScheme.secondaryContainer else MaterialTheme.colorScheme.onError)
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    CustomText(text = uiState.characters?.status ?: "")
                                    Spacer(modifier = Modifier.width(4.dp))
                                    CustomText(text = "-")
                                    Spacer(modifier = Modifier.width(4.dp))
                                    CustomText(text = uiState.characters?.species ?: "")
                                    Spacer(modifier = Modifier.width(4.dp))
                                    CustomText(text = "-")
                                    Spacer(modifier = Modifier.width(4.dp))
                                    CustomText(text = uiState.characters?.gender ?: "")
                                }
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                CustomCard {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Row() {
                            CustomText(text = "Origin:", fontWeight = FontWeight.Bold)
                            Spacer(modifier = Modifier.width(10.dp))
                            CustomText(text = uiState.characters?.origin ?: "")
                        }
                        Spacer(modifier = Modifier.width(5.dp))
                        Row() {
                            CustomText(text = "Location:", fontWeight = FontWeight.Bold)
                            Spacer(modifier = Modifier.width(10.dp))
                            CustomText(text = uiState.characters?.location ?: "")
                        }
                        Spacer(modifier = Modifier.width(5.dp))
                        Row() {
                            CustomText(text = "Fist episode:", fontWeight = FontWeight.Bold)
                            Spacer(modifier = Modifier.width(10.dp))
                            CustomText(text = "20122")
                        }
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))

                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    ),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
                    modifier = Modifier
                        .then(if (showMore) Modifier else Modifier.height(180.dp))
                        .animateContentSize()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp, bottom = 10.dp, start = 16.dp, end = 16.dp)
                    ) {

                        CustomText(text = "Episodes where this character appears:")
                        Spacer(modifier = Modifier.height(15.dp))

                        FlowRow(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            maxLines = if (showMore) Int.MAX_VALUE else 2
                        ) {
                            uiState.characters?.episode?.forEach { episode ->
                                Card(
                                    colors = CardDefaults.cardColors(
                                        containerColor = MaterialTheme.colorScheme.tertiaryContainer
                                    ),
                                    modifier = Modifier.padding(bottom = 8.dp)
                                ) {
                                    CustomText(
                                        modifier = Modifier.padding(
                                            vertical = 4.dp,
                                            horizontal = 16.dp
                                        ),
                                        text = episode.toString()
                                            .substringAfter("api/")
                                            .replace("/", " ")
                                    )
                                }
                            }
                        }
                        Spacer(modifier = Modifier.weight(1f))


                        CustomButton(
                            onClick = { showMore = !showMore },
                            modifier = Modifier
                                .align(Alignment.End)
                                .width(100.dp),
                            contentPadding = PaddingValues(
                                horizontal = 12.dp,
                                vertical = 8.dp
                            )
                        ) {
                            CustomText(
                                text = if (showMore) "Show less" else "Show more",
                                style = MaterialTheme.typography.labelMedium,
                            )
                        }
                    }
                }


            }
        }
    }
}




