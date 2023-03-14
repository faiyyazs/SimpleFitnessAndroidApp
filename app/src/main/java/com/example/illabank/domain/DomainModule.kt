package com.example.illabank.domain

import com.example.illabank.domain.repository.TrainerRepository
import com.example.illabank.domain.usecases.FetchLiveShowsUseCase
import com.example.illabank.domain.usecases.FetchTrainersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun providesFetchTrainersUseCase(trainerRepository: TrainerRepository): FetchTrainersUseCase =
        FetchTrainersUseCase(trainerRepository)

    @Provides
    fun providesFetchLiveShowsUseCase(trainerRepository: TrainerRepository): FetchLiveShowsUseCase =
        FetchLiveShowsUseCase(trainerRepository)
}