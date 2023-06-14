package com.epam.bankinggenerativeai.usecases

interface BaseUseCase<in Params, out Result> {

    /**
     * Executes the use case with the given input parameters.
     *
     * @param params The input parameters for the use case.
     * @return The result of the use case execution.
     */
    suspend fun execute(params: Params): Result
}