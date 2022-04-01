package com.arifahmadalfian.borutoapp.data.repository

import com.arifahmadalfian.borutoapp.data.local.BorutoDatabase
import com.arifahmadalfian.borutoapp.domain.model.Hero
import com.arifahmadalfian.borutoapp.domain.repository.ILocalDataSource

class LocalDataSource (
    borutoDatabase: BorutoDatabase
) : ILocalDataSource {

    private val heroDao = borutoDatabase.heroDao()

    override suspend fun getSelectedHero(heroId: Int): Hero {
        return heroDao.getSelectedHero(heroId = heroId)
    }
}