package com.christhperalta.network.model.characterModel


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterDTO(
    @SerialName("info")
    var info: Info?,
    @SerialName("results")
    var results: List<Result?>?
)

