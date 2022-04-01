package com.arifahmadalfian.borutoapp.domain.repository

import com.arifahmadalfian.borutoapp.domain.model.Hero

interface ILocalDataSource {
    suspend fun getSelectedHero(heroId: Int): Hero
}