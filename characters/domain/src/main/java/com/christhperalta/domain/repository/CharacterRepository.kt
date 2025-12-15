package com.christhperalta.domain.repository

import com.christhperalta.domain.model.Character

interface CharacterRepository {
    suspend fun getCharacters(): List<Character>
}
