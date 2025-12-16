package com.christhperalta.data.Mapper

import com.christhperalta.domain.model.Episode
import com.christhperalta.network.model.episodeModel.EpisodeDTO


fun EpisodeDTO.toModel() : List<Episode>? {
   return this.results?.map {
       Episode(
           id = it?.id ?: 0,
           name = it?.name ?: "",
           air_date = it?.airDate ?: "",
           episode = it?.episode ?: "",

       )
   }
}