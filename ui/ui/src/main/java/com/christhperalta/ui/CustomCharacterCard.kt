package com.christhperalta.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage


@Composable
fun CustomCharacterCard(
    name: String,
    status: String,
    species: String,
    imageUrl: String,
    onCharacterClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .height(300.dp)
            .clickable(onClick = onCharacterClicked),
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
                        Spacer(modifier = Modifier.width(4.dp))

                    }
                }
            }
        }
    }
}


