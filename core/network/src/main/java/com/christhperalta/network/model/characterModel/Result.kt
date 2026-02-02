package com.christhperalta.network.model.characterModel


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Result(
    @SerialName("created")
    var created: String?,
    @SerialName("episode")
    var episode: List<String?>?,
    @SerialName("gender")
    var gender: String?,
    @SerialName("id")
    var id: Int?,
    @SerialName("image")
    var image: String?,
    @SerialName("location")
    var location: LocationDTO?,
    @SerialName("name")
    var name: String?,
    @SerialName("origin")
    var origin: OriginDTO?,
    @SerialName("species")
    var species: String?,
    @SerialName("status")
    var status: String?,
    @SerialName("type")
    var type: String?,
    @SerialName("url")
    var url: String?
)