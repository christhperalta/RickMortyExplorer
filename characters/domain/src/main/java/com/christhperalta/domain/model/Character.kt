package com.christhperalta.domain.model

data class Character(
    var created: String?,
    var episode: List<String?>?,
    var gender: String?,
    var id: Int?,
    var image: String?,
    var location: Location?,
    var name: String?,
    var origin: Origin?,
    var species: String?,
    var status: String?,
    var type: String?,
    var url: String?
)

data class Origin(
    var name: String?,
    var url: String?
)

data class Location(
    var name: String?,
    var url: String?
)