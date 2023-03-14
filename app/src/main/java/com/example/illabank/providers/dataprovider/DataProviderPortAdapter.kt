package com.example.illabank.providers.dataprovider

import com.example.illabank.R
import com.example.illabank.data.ports.DataProviderPort
import com.example.illabank.domain.model.LiveShow
import com.example.illabank.domain.model.Trainer

class DataProviderPortAdapter : DataProviderPort {

    private val trainersData = mutableListOf<Trainer>()
    private val liveShowData = mutableListOf<LiveShow>()

    override suspend fun fetchTrainers(): List<Trainer> {
        trainersData.clear();
        for (index in 1..10) {
            trainersData.add(
                Trainer(
                    id = index,
                    image = R.drawable.trainer,
                    name = "Trainer $index"
                ),
            )
        }
        return trainersData
    }

    override suspend fun fetchLiveShows(): List<LiveShow> {
        liveShowData.clear();
        for (index in 1..5) {
            liveShowData.add(
                LiveShow(
                    carouselId = index,
                    carouselImage = R.drawable.item_live
                ),
            )
        }
        return liveShowData
    }

}