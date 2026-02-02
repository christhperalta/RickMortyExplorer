package com.example.datasource.dataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.datasource.CharacterDAO
import com.example.datasource.entities.FavoriteCharacter


@Database(entities = [FavoriteCharacter::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {
    abstract fun characterDAO() : CharacterDAO


    companion object {
        const val DATABASE_NAME = "app_db"
    }

}