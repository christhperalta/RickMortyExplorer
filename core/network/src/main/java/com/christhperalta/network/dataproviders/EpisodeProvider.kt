package com.christhperalta.network.dataproviders

import com.christhperalta.network.ApiService
import com.christhperalta.network.model.episodeModel.EpisodeDTO
import jakarta.inject.Inject

class EpisodeProvider @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getEpisodes(): EpisodeDTO = apiService.getEpisodes()


}