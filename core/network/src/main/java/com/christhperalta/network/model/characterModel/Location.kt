package com.christhperalta.network.model.characterModel


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LocationDTO(
    @SerialName("name")
    var name: String?,
    @SerialName("url")
    var url: String?
)