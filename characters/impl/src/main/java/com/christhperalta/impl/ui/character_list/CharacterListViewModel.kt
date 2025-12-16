package com.christhperalta.impl.ui.character_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.christhperalta.data.repository.CharacterRepositoryImpl
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
                        characters = result,
                        allCharacters = result
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


    fun filterCharactersByName(name: String) {
        _uiState.update { state ->
            val normalizedName = name.trim().lowercase()
            val filteredCharacters = if (normalizedName.isEmpty()) {
                state.allCharacters
            } else {
                state.allCharacters.filter { character ->
                    character.name.contains(normalizedName, ignoreCase = true)
                }
            }
            state.copy(characters = filteredCharacters)
        }
    }



    fun updateStatusFilter(status: String) {
        applyFiltersAndSort(status)
    }

    private fun getStatusOrder(status: String): Int {
        return when (status.lowercase()) {
            "alive" -> 1
            "dead" -> 2
            "unknown" -> 3
            else -> 4
        }
    }

    private fun applyFiltersAndSort(currentStatusFilter : String) {
        _uiState.update { state ->
            var processedList = state.allCharacters
            val normalizedStatus = currentStatusFilter.trim().lowercase()
            if (normalizedStatus.isNotEmpty()) {
                processedList = processedList.filter { character ->
                    character.status.lowercase() == normalizedStatus
                }
            }
            val sortedList = processedList.sortedWith(
                compareBy { character ->
                    getStatusOrder(character.status)
                }
            )
            state.copy(characters = sortedList)
        }
    }





}