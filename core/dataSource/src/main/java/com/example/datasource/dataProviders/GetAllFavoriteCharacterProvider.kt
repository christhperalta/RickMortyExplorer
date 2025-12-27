package com.example.datasource.dataProviders

import com.example.datasource.CharacterDAO
import javax.inject.Inject

class GetAllFavoriteCharacterProvider @Inject constructor(
    private val characterDAO: CharacterDAO
){

    fun getAllFavoriteCharacter() = characterDAO.getAll()
}