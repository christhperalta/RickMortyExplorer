package com.christhperalta.impl.ui.character_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.christhperalta.data.repository.CharacterRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


@HiltViewModel
class CharacterDetailsViewModel @Inject constructor(
    private val characterRepositoryImpl: CharacterRepositoryImpl
) : ViewModel() {


    private val _uiState = MutableStateFlow(CharacterDetailsUiState())
    val uiState: StateFlow<CharacterDetailsUiState> = _uiState


    fun getCharacterById(id: Int) {
        viewModelScope.launch {
            _uiState.update { state ->
                state.copy(isLoading = true)
            }
            try {
                val result = characterRepositoryImpl.getCharacter(id)
                _uiState.update { state ->
                    state.copy(
                        isLoading = false,
                        characters = result
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


}