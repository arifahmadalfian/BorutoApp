package com.arifahmadalfian.borutoapp.domain.use_case.save_onboarding

import com.arifahmadalfian.borutoapp.data.repository.Repository

class SaveOnBoarding(
    private val repository: Repository
) {
    suspend operator fun invoke(completed: Boolean) {
        repository.saveOnBoardingState(completed = completed)
    }
}