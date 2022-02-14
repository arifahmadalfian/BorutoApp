package com.arifahmadalfian.borutoapp.data

import com.arifahmadalfian.borutoapp.domain.repository.IDataStoreOperation
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val dataStore: IDataStoreOperation
) {
    suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.saveOnBoardingState(completed = completed)
    }

    fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.getOnBoardingState()
    }
}