package com.christhperalta.network.dataproviders

import com.christhperalta.network.ApiService
import jakarta.inject.Inject

class PlanetProvider @Inject constructor(
    private val apiService: ApiService

) {

    suspend fun getPlanets() = apiService.getLocation()


}