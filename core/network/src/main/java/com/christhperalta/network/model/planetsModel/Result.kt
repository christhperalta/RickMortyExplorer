package com.christhperalta.network.model.planetsModel


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Result(
    @SerialName("created")
    var created: String?,
    @SerialName("dimension")
    var dimension: String?,
    @SerialName("id")
    var id: Int?,
    @SerialName("name")
    var name: String?,
    @SerialName("residents")
    var residents: List<String?>?,
    @SerialName("type")
    var type: String?,
    @SerialName("url")
    var url: String?
)