package com.example.datasource.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class FavoriteCharacter(
    @PrimaryKey val id : Int,
    @ColumnInfo(name = "name") val name : String,
    @ColumnInfo(name = "status") val status : String,
    @ColumnInfo(name = "species") val species : String,
    @ColumnInfo(name = "urlImage") val urlImage : String
)
