package com.christhperalta.network.model.episodeModel


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Info(
    @SerialName("count")
    var count: Int?,
    @SerialName("next")
    var next: String?,
    @SerialName("pages")
    var pages: Int?,
    @SerialName("prev")
    var prev: String?
)