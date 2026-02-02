package com.christhperalta.network.model.episodeModel


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EpisodeDTO(
    @SerialName("info")
    var info: Info?,
    @SerialName("results")
    var results: List<Result?>?
)