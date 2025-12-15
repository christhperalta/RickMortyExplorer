package com.christhperalta.impl.ui.character_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.christhperalta.data.repository.CharacterRepositoryImpl
import com.christhperalta.domain.model.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    private val characterRepositoryImpl: CharacterRepositoryImpl
) : ViewModel() {

    private val _uiState = MutableStateFlow(CharacterListUiState())
    val uiState: StateFlow<CharacterListUiState> = _uiState


    init {
        viewModelScope.launch {
            _uiState.update { state ->
                state.copy(isLoading = true)
            }
            try {
                val result = characterRepositoryImpl.getCharacters()
                _uiState.update {state ->
                    state.copy(
                        isLoading = false,
                        characters = result
                    )
                }

            }catch (e : Exception) {
                _uiState.update {state ->
                    state.copy(
                        isLoading = false,
                        errorMessage = e.message

                    )
                }
            }

        }
    }



}