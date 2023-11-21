package com.example.borutoapp.di

import com.example.borutoapp.data.repository.Repository
import com.example.borutoapp.domain.use_cases.UseCases
import com.example.borutoapp.domain.use_cases.get_heroes_use_case.GetAllHeroesUseCase
import com.example.borutoapp.domain.use_cases.read_onboarding_use_case.ReadOnBoardingUseCase
import com.example.borutoapp.domain.use_cases.save_onboarding_use_case.SaveOnBoardingUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideUseCases(
        repository: Repository
    ): UseCases {
        return UseCases(
            saveOnBoardingUseCase = SaveOnBoardingUseCase(repository),
            readOnBoardingUseCase = ReadOnBoardingUseCase(repository),
            getAllHeroesUseCase = GetAllHeroesUseCase(repository)
        )
    }
}