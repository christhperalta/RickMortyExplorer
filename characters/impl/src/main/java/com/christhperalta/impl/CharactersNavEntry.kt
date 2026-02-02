package com.christhperalta.impl

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.ui.NavDisplay
import com.christhperalta.api.CharacterDetails
import com.christhperalta.api.CharactersList
import com.christhperalta.impl.ui.character_list.CharactersListScreen
import com.christhperalta.impl.ui.character_details.CharacterDetailsScreen

fun EntryProviderScope<NavKey>.charactersListEntry(backStack: NavBackStack<NavKey>) {
    entry<CharactersList> {
        CharactersListScreen(
            onCharacterDetailsClicked = { characterId -> backStack.add(CharacterDetails(characterId)) },
            onBack = { backStack.removeLastOrNull() }
        )
    }
}

fun EntryProviderScope<NavKey>.characterDetailsEntry(
    backStack: NavBackStack<NavKey>,
) {
    entry<CharacterDetails>(
        metadata = NavDisplay.transitionSpec {
            slideInVertically(
                initialOffsetY = { it },
                animationSpec = tween(1000),

                ) togetherWith ExitTransition.KeepUntilTransitionsFinished
        } + NavDisplay.popTransitionSpec {
            EnterTransition.None togetherWith
                    slideOutVertically(
                        targetOffsetY = { it },
                        animationSpec = tween(1000)
                    )
        } + NavDisplay.predictivePopTransitionSpec {
            EnterTransition.None togetherWith
                    slideOutVertically(
                        targetOffsetY = { it },
                        animationSpec = tween(1000)
                    )
        }
    ) { key ->
        CharacterDetailsScreen(
            onBack = { backStack.removeLastOrNull() },
            characterId = key.characterId
        )
    }
}
