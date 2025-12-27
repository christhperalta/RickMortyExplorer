package com.christhperalta.impl.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.repository.CollectionRepositoryImpl
import com.example.domain.repository.CollectionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CollectionScreenViewModel @Inject constructor (
    private val collectionRepositoryImpl: CollectionRepositoryImpl
) : ViewModel()  {


    private val _uiState = MutableStateFlow(CollectionUiState())
    val uiState : StateFlow<CollectionUiState> = _uiState



    init {
      viewModelScope.launch {
          _uiState.update { state ->
              state.copy(
                 isLoading = true
              )
          }
          try {


              collectionRepositoryImpl.getCharacters().collect{ characters ->
                _uiState.update { state ->
                    state.copy(
                        favoriteCharacters = characters,
                        isLoading = false
                    )
                }
            }



          }catch (e : Exception){
              _uiState.update { state ->
                  state.copy(
                      errorMessage = e.message,
                      isLoading = false
                  )
              }

          }
      }
    }

}