package com.christhperalta.impl.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.christhperalta.impl.R
import com.christhperalta.ui.CustomButton
import com.christhperalta.ui.CustomCard
import com.christhperalta.ui.CustomText
import com.christhperalta.ui.CustomTopAppBar
import com.christhperalta.ui.Logo

@Composable
fun HomeScreen(
    onCharacterClicked: () -> Unit,
    onEpisodesClicked: () -> Unit,
    onPlanetsClicked: () -> Unit,
    onMissionsClicked: () -> Unit,
    onCollectionClicked: () -> Unit,
    onProfileClicked: () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CustomTopAppBar(
                title = "Rick & Morty Explorer",
                accionButton = true,
                onClick = onProfileClicked
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

            Logo()
            Spacer(modifier = Modifier.height(60.dp))
            CustomCard(
                title = "Explorer"
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
            Spacer(modifier = Modifier.height(30.dp))
            CustomCard(
                title = "Missions"
            ) {
                CustomButton(onClick = onMissionsClicked, modifier = Modifier.weight(1f)) {
                    CustomText(text = "Active Missions")
                }
            }

            Spacer(modifier = Modifier.height(30.dp))
            CustomCard(
                title = "Collection"
            ) {
                CustomButton(onClick = onCollectionClicked, modifier = Modifier.weight(1f)) {
                    CustomText(text = "Your favorite characters")
                }
            }

        }
    }
}


