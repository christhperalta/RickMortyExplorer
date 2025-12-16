package com.christhperalta.data.repository

import com.christhperalta.data.mapper.toModel
import com.christhperalta.domain.model.Character
import com.christhperalta.domain.model.CharacterDetails
import com.christhperalta.domain.repository.CharacterRepository
import com.christhperalta.network.dataproviders.CharacterDetailsProvider
import com.christhperalta.network.dataproviders.CharacterProvider
import jakarta.inject.Inject

class CharacterRepositoryImpl  @Inject constructor(
    private val characterProvider: CharacterProvider,
    private val characterDetailsProvider: CharacterDetailsProvider
) : CharacterRepository {
    override suspend fun getCharacters(): List<Character> {
        val result = characterProvider.getCharacters().toModel()
        return result ?: emptyList()
    }

    override suspend fun getCharacter(id: Int): CharacterDetails {
        val result = characterDetailsProvider.getCharacterById(id)
        return result.toModel()

    }

}