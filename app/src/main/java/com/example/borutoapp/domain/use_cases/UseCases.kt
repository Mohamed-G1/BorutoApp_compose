package com.example.borutoapp.domain.use_cases

import com.example.borutoapp.domain.use_cases.get_heroes_use_case.GetAllHeroesUseCase
import com.example.borutoapp.domain.use_cases.read_onboarding_use_case.ReadOnBoardingUseCase
import com.example.borutoapp.domain.use_cases.save_onboarding_use_case.SaveOnBoardingUseCase

data class UseCases(
    val saveOnBoardingUseCase: SaveOnBoardingUseCase,
    val readOnBoardingUseCase: ReadOnBoardingUseCase,
    val getAllHeroesUseCase: GetAllHeroesUseCase
)
