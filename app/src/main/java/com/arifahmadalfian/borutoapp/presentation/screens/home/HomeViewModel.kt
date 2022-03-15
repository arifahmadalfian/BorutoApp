package com.arifahmadalfian.borutoapp.presentation.screens.home

import androidx.lifecycle.ViewModel
import com.arifahmadalfian.borutoapp.domain.use_case.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: UseCases
): ViewModel() {
    val getAllHeroes = useCase.getAllHeroesUseCase()
}