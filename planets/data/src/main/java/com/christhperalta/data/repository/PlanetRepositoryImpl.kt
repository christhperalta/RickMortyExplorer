package com.christhperalta.data.repository

import com.christhperalta.data.mapper.toModel
import com.christhperalta.domain.model.Planet
import com.christhperalta.domain.repository.PlanetRepository
import com.christhperalta.network.dataproviders.PlanetProvider
import jakarta.inject.Inject


class PlanetRepositoryImpl @Inject constructor(
    private val planetProvider: PlanetProvider
) : PlanetRepository {
    override suspend fun getPlanets(): List<Planet> {
        val result = planetProvider.getPlanets().toModel()
        return result  ?: emptyList()

    }
}