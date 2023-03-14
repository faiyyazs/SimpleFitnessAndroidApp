package com.example.illabank.providers.dataprovider

import com.example.illabank.data.ports.DataProviderPort
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class DataProviderModule {

    @Provides
    fun provideMyDataProvider(): DataProviderPort =
        DataProviderPortAdapter()
}