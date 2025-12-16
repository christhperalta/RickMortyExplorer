package com.christhperalta.network.dataproviders

import com.christhperalta.network.ApiService
import javax.inject.Inject

class CharacterDetailsProvider @Inject constructor(
    private val apiService: ApiService

) {

    suspend fun getCharacterById(id: Int) = apiService.getCharacterById(id)

}

