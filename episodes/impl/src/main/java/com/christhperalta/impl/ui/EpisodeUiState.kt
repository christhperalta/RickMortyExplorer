package com.christhperalta.impl.ui

import com.christhperalta.domain.model.Episode

data class EpisodeUiState(
    val isLoading: Boolean = true,
    val episode: List<Episode> = emptyList(),
    val allEpisode: List<Episode> = emptyList(),
    val errorMessage: String? = null,
    val isRefreshing: Boolean = false
)



