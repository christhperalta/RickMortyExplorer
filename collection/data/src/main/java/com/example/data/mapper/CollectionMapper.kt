package com.example.data.mapper

import com.example.datasource.entities.FavoriteCharacter
import com.example.domain.model.Character

//
//fun CharacterDTO.toModel() : List<Character>? {
//    return this.results?.map {
//        Character(
//            id = it?.id ?: 0,
//            name = it?.name ?: "",
//            status = it?.status ?: "",
//            species = it?.species ?: "",
//            image = it?.image ?: "",
//        )
//    }
//}
//
//
//fun Result.toModel() = CharacterDetails(
//    id = id ?: 0,
//    name = name ?: "",
//    status = status ?: "",
//    species = species ?: "",
//    type = type ?: "",
//    gender = gender ?: "",
//    origin = origin?.name ?: "",
//    location = location?.name ?: "",
//    image = image ?: "",
//    episode = episode ?: emptyList(),
//    url = url ?: "",
//    created = created ?: ""
//
//)


fun FavoriteCharacter.toDomain(): Character {
    return Character(
        id = id,
        name = name,
        status = status,
        species = species,
        image = urlImage
    )
}