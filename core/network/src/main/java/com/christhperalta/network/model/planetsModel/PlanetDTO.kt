package com.christhperalta.network.model.planetsModel


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlanetDTO(
    @SerialName("info")
    var info: Info?,
    @SerialName("results")
    var results: List<Result?>?
)