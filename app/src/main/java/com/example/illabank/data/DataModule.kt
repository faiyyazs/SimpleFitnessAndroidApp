package com.example.illabank.data

import com.example.illabank.data.ports.DataProviderPort
import com.example.illabank.data.repository.TrainerRepositoryImpl
import com.example.illabank.domain.repository.TrainerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Singleton
    @Provides
    fun trainersRepository(
        myDataProviderPort: DataProviderPort
    ): TrainerRepository = TrainerRepositoryImpl(myDataProviderPort)
}