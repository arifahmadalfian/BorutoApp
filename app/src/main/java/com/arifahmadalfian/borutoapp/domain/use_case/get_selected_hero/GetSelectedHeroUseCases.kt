package com.arifahmadalfian.borutoapp.domain.use_case.get_selected_hero

import com.arifahmadalfian.borutoapp.data.repository.Repository
import com.arifahmadalfian.borutoapp.domain.model.Hero

class GetSelectedHeroUseCases(
    private val repository: Repository
) {
    suspend operator fun invoke(heroId: Int): Hero {
        return repository.getSelectedHero(heroId = heroId)
    }
}