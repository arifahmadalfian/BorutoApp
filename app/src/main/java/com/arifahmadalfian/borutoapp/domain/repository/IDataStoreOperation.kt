package com.arifahmadalfian.borutoapp.domain.repository

import kotlinx.coroutines.flow.Flow

interface IDataStoreOperation {
    suspend fun saveOnBoardingState(completed: Boolean)
    fun getOnBoardingState(): Flow<Boolean>
}