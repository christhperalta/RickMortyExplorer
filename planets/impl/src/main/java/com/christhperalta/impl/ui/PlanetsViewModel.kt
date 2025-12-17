package com.christhperalta.impl.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.christhperalta.data.repository.PlanetRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class PlanetsViewModel @Inject constructor(
private val planetRepositoryImpl: PlanetRepositoryImpl
) : ViewModel() {


    private val _uiState = MutableStateFlow(PlanetsUiState())
    val uiState: StateFlow<PlanetsUiState> = _uiState




    init {
        viewModelScope.launch {
            try {
                val result = planetRepositoryImpl.getPlanets()
                _uiState.update { state ->
                    state.copy(
                        isLoading = false,
                        planet = result,
                        allPlanets = result
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

    fun filterPlanetName(name: String) {
        _uiState.update { state ->
            val normalizedName = name.trim().lowercase()
            val filteredCharacters = if (normalizedName.isEmpty()) {
                state.allPlanets
            } else {
                state.allPlanets.filter { planets ->
                    planets.name.contains(normalizedName, ignoreCase = true)
                }
            }
            state.copy(planet = filteredCharacters)
        }
    }




}