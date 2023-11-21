package com.example.borutoapp.data.repository

import androidx.paging.PagingData
import com.example.borutoapp.domain.model.Hero
import com.example.borutoapp.domain.repository.DataStoreOperations
import com.example.borutoapp.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val dataStoreOperations: DataStoreOperations
) {

    fun getAllHeroes(): Flow<PagingData<Hero>> = remoteDataSource.getAllHeroes()

    suspend fun saveOnBoardingState(completed: Boolean) =
        dataStoreOperations.saveOnBoardingState(completed = completed)

    fun readOnBoardingState(): Flow<Boolean> =
        dataStoreOperations.readOnBoardingState()
}