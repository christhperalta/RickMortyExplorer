package com.christhperalta.network

import com.christhperalta.network.model.characterModel.CharacterDTO
import com.christhperalta.network.model.characterModel.Result
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {


    @GET("character")
    suspend fun getCharacters() : CharacterDTO

    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id: Int): Result


}