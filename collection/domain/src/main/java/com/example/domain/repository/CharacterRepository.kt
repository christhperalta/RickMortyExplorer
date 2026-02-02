package com.example.domain.repository

import com.example.domain.model.Character
import kotlinx.coroutines.flow.Flow


interface CollectionRepository {
     fun getCharacters(): Flow<List<Character>>
}
