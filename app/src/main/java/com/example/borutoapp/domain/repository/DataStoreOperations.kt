package com.example.borutoapp.domain.repository

import kotlinx.coroutines.flow.Flow

interface DataStoreOperations {
    suspend fun saveOnboardingValue(completed: Boolean)
    fun getOnboardingValue(): Flow<Boolean>
}