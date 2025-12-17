package com.christhperalta.domain.repository

import com.christhperalta.domain.model.Planet

interface PlanetRepository {

    suspend fun getPlanets(): List<Planet>



}