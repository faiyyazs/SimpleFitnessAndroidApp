package com.example.illabank.domain.usecases

import com.example.illabank.domain.model.Trainer
import com.example.illabank.domain.repository.TrainerRepository
import com.example.illabank.domain.usecases.base.BaseUseCase
import com.example.illabank.domain.usecases.base.Params

class FetchTrainersUseCase(private val trainerRepository: TrainerRepository) :
    BaseUseCase<FetchTrainersUseCaseParams, List<Trainer>>() {


    override suspend fun execute(params: FetchTrainersUseCaseParams): List<Trainer> {
        if (params.verify()) {
            return trainerRepository.getTrainersList()
        }else{
            throw Exception("Invalid Params")
        }

    }
}

class FetchTrainersUseCaseParams : Params() {
    override fun verify(): Boolean {
        return true
    }

}