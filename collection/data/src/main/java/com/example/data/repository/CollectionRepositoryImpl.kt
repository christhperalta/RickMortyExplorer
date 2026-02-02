package com.example.data.repository


import com.example.data.mapper.toDomain
import com.example.datasource.dataProviders.GetAllFavoriteCharacterProvider
import com.example.domain.model.Character
import com.example.domain.repository.CollectionRepository
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CollectionRepositoryImpl  @Inject constructor(
  private val getAllFavoriteCharacterProvider: GetAllFavoriteCharacterProvider
) : CollectionRepository {
    override fun getCharacters(): Flow<List<Character>> {
        return getAllFavoriteCharacterProvider
            .getAllFavoriteCharacter()
            .map { favoriteList ->
                favoriteList.map { it.toDomain() }
            }
    }


}