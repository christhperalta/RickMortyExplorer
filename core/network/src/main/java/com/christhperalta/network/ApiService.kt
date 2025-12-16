package com.christhperalta.network

import com.christhperalta.network.model.characterModel.CharacterDTO
import com.christhperalta.network.model.characterModel.Result
import com.christhperalta.network.model.episodeModel.EpisodeDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {


    @GET("character")
    suspend fun getCharacters() : CharacterDTO

    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id: Int): Result

    @GET("character")
    suspend fun addMoreCharacters(
        @Query("page") pageNum: Int
    ) : CharacterDTO


    @GET("episode")
    suspend fun getEpisodes() : EpisodeDTO




}