package com.christhperalta.impl.ui

import com.christhperalta.domain.model.Planet

data class PlanetsUiState(
    val isLoading: Boolean = true,
    val planet: List<Planet> = emptyList(),
    val allPlanets: List<Planet> = emptyList(),
    val errorMessage: String? = null,
    val isRefreshing: Boolean = false
)
