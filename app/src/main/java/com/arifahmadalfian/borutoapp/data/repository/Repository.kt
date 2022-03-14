package com.arifahmadalfian.borutoapp.data.repository

import androidx.paging.PagingData
import com.arifahmadalfian.borutoapp.domain.model.Hero
import com.arifahmadalfian.borutoapp.domain.repository.IDataStoreOperation
import com.arifahmadalfian.borutoapp.domain.repository.IRemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val remote: IRemoteDataSource,
    private val dataStore: IDataStoreOperation
) {
    fun getAllHeroes(): Flow<PagingData<Hero>> {
        return remote.getAllHeroes()
    }

    fun searchHeroes(): Flow<PagingData<Hero>> {
        return remote.searchHeroes()
    }

    suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.saveOnBoardingState(completed = completed)
    }

    fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.getOnBoardingState()
    }
}