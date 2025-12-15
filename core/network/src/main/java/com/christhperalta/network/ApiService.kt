package com.christhperalta.network

import com.christhperalta.network.model.characterModel.CharacterDTO
import retrofit2.http.GET

interface ApiService {


    @GET("character")
    suspend fun getCharacters() : CharacterDTO


}