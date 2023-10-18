package com.example.borutoapp.di

import android.content.Context
import com.example.borutoapp.data.dataStore_repository.DataStoreOperationsImpl
import com.example.borutoapp.data.dataStore_repository.Repository
import com.example.borutoapp.domain.repository.DataStoreOperations
import com.example.borutoapp.domain.use_cases.UseCases
import com.example.borutoapp.domain.use_cases.read_onboarding_use_case.ReadOnBoardingUseCase
import com.example.borutoapp.domain.use_cases.save_onboarding_use_case.SaveOnBoardingUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Provides
    @Singleton
    fun provideDataStoreOperations(@ApplicationContext context: Context): DataStoreOperations {
        return DataStoreOperationsImpl(context)
    }

    @Provides
    @Singleton
    fun provideOnBoardingUseCases(repository: Repository): UseCases {
        return UseCases(
            saveOnBoardingUseCase = SaveOnBoardingUseCase(repository = repository),
            readOnBoardingUseCase = ReadOnBoardingUseCase(repository = repository)
        )
    }
}