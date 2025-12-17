package com.christhperalta.impl.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.christhperalta.ui.CustomText
import com.christhperalta.ui.CustomTopAppBar
import com.christhperalta.ui.SimpleSearchBar

@Composable
fun PlanetsScreen(
    onBack : () -> Unit,
    viewModel: PlanetsViewModel  = hiltViewModel()
) {

    val uiState = viewModel.uiState.collectAsStateWithLifecycle()


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Column {
                CustomTopAppBar(title = "Episodes", accionButton = false, onClick = onBack)
                SimpleSearchBar(onSearchTextChange = viewModel::filterPlanetName)
            }
        }
    ) { innerPadding ->

        if (uiState.value.isLoading) {
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
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(uiState.value.planet.size) { index ->
                    val planets = uiState.value.planet[index]
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surfaceVariant
                        ),
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
                        modifier = Modifier.height(80.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 20.dp, bottom = 10.dp, start = 16.dp, end = 16.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically

                            ) {

                                CustomText(text = planets.name, fontWeight = FontWeight.Bold)
                                Spacer(modifier = Modifier.width(4.dp))
                            }
                            Spacer(modifier = Modifier.height(4.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically

                            ) {

                                CustomText(text = "Type", fontWeight = FontWeight.Bold)
                                Spacer(modifier = Modifier.width(4.dp))
                                CustomText(text = "-")
                                Spacer(modifier = Modifier.width(4.dp))
                                CustomText(text = planets.type)
                                Spacer(modifier = Modifier.width(4.dp))
                                CustomText(text = "-")
                                Spacer(modifier = Modifier.width(4.dp))
                                CustomText(text = planets.dimension)
                            }

                        }
                    }
                }
            }
        }
    }
}

