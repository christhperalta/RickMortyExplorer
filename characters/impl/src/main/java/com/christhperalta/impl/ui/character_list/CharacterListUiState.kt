package com.christhperalta.impl.ui.character_list

import com.christhperalta.domain.model.Character

data class CharacterListUiState(
    val isLoading: Boolean = true,
    val characters: List<Character> = emptyList(),
    val errorMessage: String? = null
)
