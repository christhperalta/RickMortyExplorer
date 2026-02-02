package com.example.datasource

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.datasource.entities.FavoriteCharacter
import kotlinx.coroutines.flow.Flow


@Dao
interface CharacterDAO {

    @Query("SELECT * FROM FavoriteCharacter")
    fun getAll() : Flow<List<FavoriteCharacter>>

    @Insert
    suspend fun insertFavoriteCharacter (favoriteCharacter: FavoriteCharacter)

//    @Delete
//    suspend fun deleteFavoriteCharacter ()



}