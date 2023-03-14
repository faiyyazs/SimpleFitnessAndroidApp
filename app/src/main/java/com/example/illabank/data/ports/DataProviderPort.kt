package com.example.illabank.data.ports

import com.example.illabank.domain.model.LiveShow
import com.example.illabank.domain.model.Trainer

interface DataProviderPort {

    suspend fun fetchTrainers(): List<Trainer>
    suspend fun fetchLiveShows(): List<LiveShow>

}