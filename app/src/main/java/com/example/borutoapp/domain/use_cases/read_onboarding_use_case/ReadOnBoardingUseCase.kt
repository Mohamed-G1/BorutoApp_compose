package com.example.borutoapp.domain.use_cases.read_onboarding_use_case

import com.example.borutoapp.data.dataStore_repository.Repository
import kotlinx.coroutines.flow.Flow

class ReadOnBoardingUseCase(
    private val repository: Repository
) {
    operator fun invoke(): Flow<Boolean> =
        repository.readOnBoardingState()
}