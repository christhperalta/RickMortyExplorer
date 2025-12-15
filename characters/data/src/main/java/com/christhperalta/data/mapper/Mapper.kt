package com.christhperalta.data.mapper

import com.christhperalta.domain.model.Character
import com.christhperalta.network.model.characterModel.CharacterDTO


fun CharacterDTO.toModel() : List<Character>? {
    return this.results?.map {
        Character(
            id = it?.id ?: 0,
            name = it?.name ?: "",
            status = it?.status ?: "",
            species = it?.species ?: "",
            gender = it?.gender ?: "",
            image = it?.image ?: "",
            origin = it?.origin?.name ?: "",
            location = it?.location?.name ?: ""
        )
    }
}