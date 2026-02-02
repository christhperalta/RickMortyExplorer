package com.christhperalta.impl.ui

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.christhperalta.api.CharacterDetails
import com.christhperalta.api.CharactersList
import com.christhperalta.impl.ui.character_list.CharactersListScreen
import com.christhperalta.impl.ui.character_details.CharacterDetailsScreen

fun EntryProviderScope<NavKey>.charactersListEntry(backStack: NavBackStack<NavKey>) {
    entry<CharactersList> {
        CharactersListScreen(
            onCharacterDetailsClicked = { characterId -> backStack.add(CharacterDetails(characterId)) }
        )
    }
}

fun EntryProviderScope<NavKey>.characterDetailsEntry() {
    entry<CharacterDetails> {
        CharacterDetailsScreen()
    }
}
