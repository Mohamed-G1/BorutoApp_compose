package com.example.borutoapp.domain.use_cases.save_onboarding_use_case

import com.example.borutoapp.data.dataStore_repository.Repository

class SaveOnBoardingUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(completed: Boolean) =
        repository.saveOnBoardingState(completed = completed)
}
