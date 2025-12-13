package com.christhperalta.impl.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.christhperalta.ui.CustomButton
import com.christhperalta.ui.CustomText
import com.christhperalta.ui.CustomTopAppBar

@Composable
fun HomeScreen(
    onCharacterClicked: () -> Unit,
    onEpisodesClicked: () -> Unit,
    onPlanetsClicked: () -> Unit,
    onMissionsClicked : () -> Unit,
    onCollectionClicked : () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CustomTopAppBar(
                text = "Hola, RickUser"
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Card {
                Column(
                    modifier = Modifier.padding(vertical = 20.dp, horizontal = 16.dp)
                ) {

                    CustomText(text = "Explorer", style = MaterialTheme.typography.headlineSmall)
                    Spacer(modifier = Modifier.height(15.dp))
                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(15.dp)
                    ) {
                        CustomButton(onClick = onCharacterClicked, modifier = Modifier.weight(1f)) {
                            CustomText(text = "Characters")
                        }
                        CustomButton(onClick = onEpisodesClicked, modifier = Modifier.weight(1f)) {
                            CustomText(text = "Episodes")
                        }
                        CustomButton(onClick = onPlanetsClicked, modifier = Modifier.weight(1f)) {
                            CustomText(text = "Planets")
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            Card {
                Column(
                    modifier = Modifier.padding(vertical = 20.dp, horizontal = 16.dp)
                ) {

                    CustomText(text = "Missions", style = MaterialTheme.typography.headlineSmall)
                    Spacer(modifier = Modifier.height(15.dp))
                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(15.dp)
                    ) {
                        CustomButton(onClick = onMissionsClicked, modifier = Modifier.weight(1f)) {
                            CustomText(text = "Active Missions")
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            Card {
                Column(
                    modifier = Modifier.padding(vertical = 20.dp, horizontal = 16.dp)
                ) {

                    CustomText(text = "Collection", style = MaterialTheme.typography.headlineSmall)
                    Spacer(modifier = Modifier.height(15.dp))
                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(15.dp)
                    ) {
                        CustomButton(onClick = onCollectionClicked, modifier = Modifier.weight(1f)) {
                            CustomText(text = "Your favorite characters")
                        }

                    }
                }
            }

        }
    }
}

