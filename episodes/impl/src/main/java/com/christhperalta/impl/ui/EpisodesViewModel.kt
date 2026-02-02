package com.christhperalta.impl.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.christhperalta.data.repository.EpisodeRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class EpisodesViewModel @Inject constructor(
    private val episodeRepositoryImpl: EpisodeRepositoryImpl
) : ViewModel() {

    private val _uiState = MutableStateFlow(EpisodeUiState())
    val state: StateFlow<EpisodeUiState> = _uiState



    init {
        viewModelScope.launch {
            try {
                val result = episodeRepositoryImpl.getEpisodes()
                _uiState.update { state ->
                    state.copy(
                        isLoading = false,
                        episode = result,
                        allEpisode = result
                    )
                }

            } catch (e: Exception) {
                _uiState.update { state ->
                    state.copy(
                        isLoading = false,
                        errorMessage = e.message

                    )
                }
            }
        }
    }

    fun filterEpisodesName(name: String) {
        _uiState.update { state ->
            val normalizedName = name.trim().lowercase()
            val filteredCharacters = if (normalizedName.isEmpty()) {
                state.allEpisode
            } else {
                state.allEpisode.filter { episode ->
                    episode.name.contains(normalizedName, ignoreCase = true)
                }
            }
            state.copy(episode = filteredCharacters)
        }
    }




}