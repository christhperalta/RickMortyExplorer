package com.christhperalta.domain.repository

import com.christhperalta.domain.model.Episode

interface EpisodeRepository {

   suspend fun getEpisodes(): List<Episode>


}