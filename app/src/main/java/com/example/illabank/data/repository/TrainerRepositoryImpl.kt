package com.example.illabank.data.repository

import com.example.illabank.data.ports.DataProviderPort
import com.example.illabank.domain.model.LiveShow
import com.example.illabank.domain.model.Trainer
import com.example.illabank.domain.repository.TrainerRepository

class TrainerRepositoryImpl(private val dataProvider: DataProviderPort) : TrainerRepository {


    override suspend fun getTrainersList(): List<Trainer> {
        return dataProvider.fetchTrainers()
    }

    override suspend fun getLiveShowsList(): List<LiveShow> {
        return dataProvider.fetchLiveShows()
    }

}