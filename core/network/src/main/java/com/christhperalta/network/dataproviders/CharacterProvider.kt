package com.christhperalta.network.dataproviders

import com.christhperalta.network.ApiService
import javax.inject.Inject

class CharacterProvider @Inject constructor(
    private val apiService: ApiService

) {

    suspend fun getCharacters() = apiService.getCharacters()

}