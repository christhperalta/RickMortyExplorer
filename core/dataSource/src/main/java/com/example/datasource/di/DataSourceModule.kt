package com.example.datasource.di

import android.content.Context
import androidx.room.Room
import com.example.datasource.CharacterDAO
import com.example.datasource.dataBase.AppDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {


    @Provides
    fun provideDataSource (@ApplicationContext context: Context) : AppDataBase {
        return Room.databaseBuilder(
            context,
            AppDataBase::class.java,
            AppDataBase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideCharacterDao(database: AppDataBase): CharacterDAO {
        return database.characterDAO()
    }

}