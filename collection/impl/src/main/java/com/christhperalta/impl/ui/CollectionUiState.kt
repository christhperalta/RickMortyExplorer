package com.christhperalta.impl.ui

import com.example.domain.model.Character

data class CollectionUiState(
    val isLoading: Boolean = true,
    val favoriteCharacters : List<Character> = emptyList(),
    val errorMessage: String? = null
)





//data class CharacterListUiState(
//    val isLoading: Boolean = true,
//    val characters: List<com.christhperalta.domain.model.Character> = emptyList(),
//    val allCharacters: List<com.christhperalta.domain.model.Character> = emptyList(),
//    val errorMessage: String? = null,
//    val isRefreshing: Boolean = false
//)
