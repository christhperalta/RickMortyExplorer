package com.christhperalta.network.model.episodeModel


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Result(
    @SerialName("air_date")
    var airDate: String?,
    @SerialName("characters")
    var characters: List<String?>?,
    @SerialName("created")
    var created: String?,
    @SerialName("episode")
    var episode: String?,
    @SerialName("id")
    var id: Int?,
    @SerialName("name")
    var name: String?,
    @SerialName("url")
    var url: String?
)