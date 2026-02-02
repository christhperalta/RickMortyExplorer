package com.christhperalta.api

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
data object CharactersList : NavKey

@Serializable
data class CharacterDetails(val characterId : Int) : NavKey