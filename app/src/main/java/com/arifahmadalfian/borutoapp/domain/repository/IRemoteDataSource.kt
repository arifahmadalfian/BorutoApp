package com.arifahmadalfian.borutoapp.domain.repository

import androidx.paging.PagingData
import com.arifahmadalfian.borutoapp.domain.model.Hero
import kotlinx.coroutines.flow.Flow

interface IRemoteDataSource {
    fun getAllHeroes(): Flow<PagingData<Hero>>
    fun searchHeroes(query: String): Flow<PagingData<Hero>>
}