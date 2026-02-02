package com.christhperalta.data.mapper

import com.christhperalta.domain.model.Character
import com.christhperalta.domain.model.Location
import com.christhperalta.domain.model.Origin
import com.christhperalta.network.model.characterModel.CharacterDTO


fun CharacterDTO.toModel() : List<Character>? {
    return this.results?.map {
        Character(
            created = it?.created,
            episode = it?.episode,
            gender = it?.gender,
            id = it?.id,
            image = it?.image,
            location = Location(
                name = it?.location?.name,
                url = it?.location?.url
            ),
            name = it?.name,
            origin = Origin(
                name = it?.origin?.name,
                url = it?.origin?.url
            ),
            species = it?.species,
            status = it?.status,
            type = it?.type,
            url = it?.url
        )
    }
}