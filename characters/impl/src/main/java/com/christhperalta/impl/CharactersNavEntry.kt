package com.christhperalta.impl

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.christhperalta.api.CharacterDetails
import com.christhperalta.api.CharactersList
import com.christhperalta.impl.ui.CharacterDetailsScreen
import com.christhperalta.impl.ui.CharactersListScreen

fun EntryProviderScope<NavKey>.charactersListEntry(backStack: NavBackStack<NavKey>) {
    entry<CharactersList> {
        CharactersListScreen(
            onCharacterDetailsClicked = {characterId -> backStack.add(CharacterDetails(characterId))}
        )
    }
}

fun EntryProviderScope<NavKey>.characterDetailsEntry() {
    entry<CharacterDetails> {
        CharacterDetailsScreen()
    }
}
