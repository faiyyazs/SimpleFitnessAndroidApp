package com.example.illabank.domain.usecases.base

abstract class BaseUseCase<P : Params, Result> {

    abstract suspend fun execute(params: P): Result

}

