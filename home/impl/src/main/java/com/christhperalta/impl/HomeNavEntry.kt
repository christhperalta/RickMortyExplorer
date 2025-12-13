package com.christhperalta.impl

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.christhperalta.api.CharactersList
import com.christhperalta.api.Collection
import com.christhperalta.api.Episodes
import com.christhperalta.api.Home
import com.christhperalta.api.Missions
import com.christhperalta.api.Planets
import com.christhperalta.impl.ui.HomeScreen

 fun EntryProviderScope<NavKey>.homeEntry(backStack: NavBackStack<NavKey>) {
    entry<Home> {
        HomeScreen(
            onCharacterClicked = {backStack.add(CharactersList)},
            onEpisodesClicked = {backStack.add(Episodes)},
            onPlanetsClicked = {backStack.add(Planets)},
            onMissionsClicked = {backStack.add(Missions)},
            onCollectionClicked = {backStack.add(Collection)}

        )
    }
}