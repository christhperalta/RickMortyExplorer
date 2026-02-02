package com.christhperalta.data.mapper

import com.christhperalta.domain.model.Character
import com.christhperalta.domain.model.CharacterDetails
import com.christhperalta.network.model.characterModel.CharacterDTO
import com.christhperalta.network.model.characterModel.Result
import com.example.datasource.entities.FavoriteCharacter


fun CharacterDTO.toModel() : List<Character>? {
    return this.results?.map {
        Character(
            id = it?.id ?: 0,
            name = it?.name ?: "",
            status = it?.status ?: "",
            species = it?.species ?: "",
            image = it?.image ?: "",
        )
    }
}


fun Result.toModel() = CharacterDetails(
    id = id ?: 0,
    name = name ?: "",
    status = status ?: "",
    species = species ?: "",
    type = type ?: "",
    gender = gender ?: "",
    origin = origin?.name ?: "",
    location = location?.name ?: "",
    image = image ?: "",
    episode = episode ?: emptyList(),
    url = url ?: "",
    created = created ?: ""

)


fun Character.toFavoriteEntity() = FavoriteCharacter(
    id = id,
    name = name,
    status = status,
    species = species,
    urlImage = image
)