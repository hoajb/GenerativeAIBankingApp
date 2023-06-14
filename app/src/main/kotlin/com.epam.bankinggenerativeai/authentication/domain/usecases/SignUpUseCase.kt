package com.epam.bankinggenerativeai.authentication.domain.usecases

import com.epam.bankinggenerativeai.authentication.domain.entities.User
import com.epam.bankinggenerativeai.authentication.domain.repositories.AuthRepository
import com.epam.bankinggenerativeai.usecases.BaseUseCase

class SignUpUseCase(private val authRepository: AuthRepository) :
    BaseUseCase<SignUpUseCase.Params, User?> {

    data class Params(val firstName: String, val lastName: String, val email: String, val password: String)

    override suspend fun execute(params: Params): User? {
        return authRepository.signUp(params.firstName, params.lastName, params.email, params.password)
    }
}