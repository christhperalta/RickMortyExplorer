package com.christhperalta.data.repository

import com.christhperalta.data.mapper.toModel
import com.christhperalta.domain.model.Episode
import com.christhperalta.domain.repository.EpisodeRepository
import com.christhperalta.network.dataproviders.EpisodeProvider
import jakarta.inject.Inject

class EpisodeRepositoryImpl @Inject constructor(
   private val episodeProvider: EpisodeProvider
) : EpisodeRepository {
    override suspend fun getEpisodes(): List<Episode> {
        val result = episodeProvider.getEpisodes().toModel()
        return result ?: emptyList()

    }
}