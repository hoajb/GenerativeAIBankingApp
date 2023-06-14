package com.epam.bankinggenerativeai.authentication.domain.usecases

import com.epam.bankinggenerativeai.authentication.domain.entities.User
import com.epam.bankinggenerativeai.authentication.domain.repositories.AuthRepository
import com.epam.bankinggenerativeai.usecases.BaseUseCase
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val authRepository: AuthRepository) :
    BaseUseCase<LoginUseCase.Params, User?> {

    data class Params(val email: String, val password: String)

    override suspend fun execute(params: Params): User? {
        return authRepository.login(params.email, params.password)
    }
}