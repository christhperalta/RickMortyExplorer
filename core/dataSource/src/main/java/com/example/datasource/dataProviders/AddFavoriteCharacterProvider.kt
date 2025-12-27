package com.example.datasource.dataProviders

import com.example.datasource.CharacterDAO
import com.example.datasource.entities.FavoriteCharacter
import javax.inject.Inject

class AddFavoriteCharacterProvider @Inject constructor(
    private val  characterDAO: CharacterDAO
) {

    suspend fun addFavoriteCharacterProvider (favoriteCharacter: FavoriteCharacter) {
        characterDAO.insertFavoriteCharacter(favoriteCharacter)
    }
}