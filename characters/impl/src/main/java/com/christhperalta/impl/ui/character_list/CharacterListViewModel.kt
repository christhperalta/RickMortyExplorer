package com.christhperalta.impl.ui.character_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.christhperalta.data.repository.CharacterRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    private val characterRepositoryImpl: CharacterRepositoryImpl
) : ViewModel() {


    init {
        viewModelScope.launch {
            val result = characterRepositoryImpl.getCharacters()
            println("Christh $result")

        }
    }

}