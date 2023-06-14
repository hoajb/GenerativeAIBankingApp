package com.epam.bankinggenerativeai.authentication.domain.usecases

import com.epam.bankinggenerativeai.authentication.domain.repositories.AuthRepository
import com.epam.bankinggenerativeai.usecases.BaseUseCase

class ForgotPasswordUseCase(private val authRepository: AuthRepository) :
    BaseUseCase<ForgotPasswordUseCase.Params, Boolean> {

    data class Params(val email: String)

    override suspend fun execute(params: Params): Boolean {
        return authRepository.forgotPassword(params.email)
    }
}