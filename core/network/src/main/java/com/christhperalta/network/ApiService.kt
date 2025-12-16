package com.christhperalta.network

import com.christhperalta.network.model.characterModel.CharacterDTO
import com.christhperalta.network.model.characterModel.Result
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {


    @GET("character")
    suspend fun getCharacters() : CharacterDTO

    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id: Int): Result

    @GET("character") // Limpia la URL, solo queda el path base
    suspend fun addMoreCharacters(
        // Utiliza @Query para agregar el parámetro después del "?"
        @Query("page") pageNum: Int // Se recomienda usar Int para números de página
    ) : CharacterDTO


}