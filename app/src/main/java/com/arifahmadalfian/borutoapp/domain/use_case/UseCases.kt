package com.arifahmadalfian.borutoapp.domain.use_case

import com.arifahmadalfian.borutoapp.domain.use_case.get_all_heroes.GetAllHeroesUseCase
import com.arifahmadalfian.borutoapp.domain.use_case.read_onboarding.ReadOnBoarding
import com.arifahmadalfian.borutoapp.domain.use_case.save_onboarding.SaveOnBoarding

data class UseCases(
    val saveOnBoarding: SaveOnBoarding,
    val readOnBoarding: ReadOnBoarding,
    val getAllHeroesUseCase: GetAllHeroesUseCase
)
