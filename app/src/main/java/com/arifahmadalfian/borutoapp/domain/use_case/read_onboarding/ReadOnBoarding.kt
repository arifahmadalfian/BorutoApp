package com.arifahmadalfian.borutoapp.domain.use_case.read_onboarding

import com.arifahmadalfian.borutoapp.data.repository.Repository
import kotlinx.coroutines.flow.Flow

class ReadOnBoarding(
    private val repository: Repository
) {
    operator fun invoke(): Flow<Boolean> {
        return repository.readOnBoardingState()
    }
}