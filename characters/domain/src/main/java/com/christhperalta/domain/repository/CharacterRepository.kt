package com.christhperalta.domain.repository

import com.christhperalta.domain.model.Character
import com.christhperalta.domain.model.CharacterDetails

interface CharacterRepository {
    suspend fun getCharacters(): List<Character>
    suspend fun addMoreCharacters(pageNum: Int) : List<Character>
    suspend fun getCharacter(id: Int): CharacterDetails

    suspend fun addFavoriteCharacter(favoriteCharacter: Character)
}
