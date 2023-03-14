package com.example.illabank.domain.usecases

import com.example.illabank.domain.model.LiveShow
import com.example.illabank.domain.model.Trainer
import com.example.illabank.domain.repository.TrainerRepository
import com.example.illabank.domain.usecases.base.BaseUseCase
import com.example.illabank.domain.usecases.base.Params

class FetchLiveShowsUseCase(private val trainerRepository: TrainerRepository) :
    BaseUseCase<FetchLiveShowsUseCaseParams, List<LiveShow>>() {


    override suspend fun execute(params: FetchLiveShowsUseCaseParams): List<LiveShow> {
        if (params.verify()) {
            return trainerRepository.getLiveShowsList()
        } else {
            throw Exception("Invalid Params")
        }

    }
}

class FetchLiveShowsUseCaseParams : Params() {
    override fun verify(): Boolean {
        return true
    }

}