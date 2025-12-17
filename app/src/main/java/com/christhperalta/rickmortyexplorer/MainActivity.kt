package com.christhperalta.rickmortyexplorer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.christhperalta.api.Home
import com.christhperalta.impl.characterDetailsEntry
import com.christhperalta.impl.charactersListEntry
import com.christhperalta.impl.collectionEntry
import com.christhperalta.impl.episodesEntry
import com.christhperalta.impl.homeEntry
import com.christhperalta.impl.missionsEntry
import com.christhperalta.impl.planetsEntry
import com.christhperalta.impl.profileEntry
import com.christhperalta.rickmortyexplorer.ui.theme.RickMortyExplorerTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RickMortyExplorerTheme {

                val backStack = rememberNavBackStack(Home)

                NavDisplay(
                    backStack = backStack,
                    onBack = { backStack.removeLastOrNull() },
                    entryProvider = entryProvider {
                        homeEntry(backStack)
                        charactersListEntry(backStack)
                        characterDetailsEntry(backStack)
                        episodesEntry(backStack)
                        planetsEntry(backStack)
                        missionsEntry()
                        collectionEntry()
                        profileEntry()
                    }

                )

            }
        }
    }
}







