package com.christhperalta.impl.ui.character_details

import com.christhperalta.domain.model.CharacterDetails

data class CharacterDetailsUiState(
    val isLoading: Boolean = true,
    val characters: CharacterDetails? = null,
    val errorMessage: String? = null
)
