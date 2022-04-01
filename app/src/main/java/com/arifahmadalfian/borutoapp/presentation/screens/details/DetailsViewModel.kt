package com.arifahmadalfian.borutoapp.presentation.screens.details

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arifahmadalfian.borutoapp.domain.model.Hero
import com.arifahmadalfian.borutoapp.domain.use_case.UseCases
import com.arifahmadalfian.borutoapp.util.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@HiltViewModel
class DetailsViewModel(
    private val useCases: UseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _selectedHero: MutableState<Hero?> = mutableStateOf(null)
    val selectedHero: State<Hero?> = _selectedHero

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val heroId = savedStateHandle.get<Int>(Constants.DETAILS_ARGUMENT_KEY)
            _selectedHero.value = heroId?.let { useCases.getSelectedHeroUseCases(heroId = heroId) }
        }
    }
}