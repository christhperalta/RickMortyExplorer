package com.christhperalta.data.mapper

import com.christhperalta.domain.model.Planet
import com.christhperalta.network.model.planetsModel.PlanetDTO


fun PlanetDTO.toModel () : List<Planet>? {
    return this.results?.map {
        Planet(
            dimension = it?.dimension ?: "",
            id = it?.id ?: 0,
            name = it?.name ?: "",
            type = it?.type ?: ""
        )

    }
}