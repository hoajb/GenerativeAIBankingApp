package com.epam.bankinggenerativeai.authentication.data.repositories

import com.epam.bankinggenerativeai.authentication.data.datasources.LocalAuthDataSource
import com.epam.bankinggenerativeai.authentication.data.datasources.RemoteAuthDataSource
import com.epam.bankinggenerativeai.authentication.domain.entities.User
import com.epam.bankinggenerativeai.authentication.domain.repositories.AuthRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl @Inject constructor(
    private val remoteAuthDataSource: RemoteAuthDataSource,
    private val localAuthDataSource: LocalAuthDataSource
) : AuthRepository {

    override suspend fun login(email: String, password: String): User? {
        val user = remoteAuthDataSource.login(email, password)
        user?.let { localAuthDataSource.saveUser(it) }
        return user
    }

    override suspend fun signUp(
        firstName: String,
        lastName: String,
        email: String,
        password: String
    ): User? {
        val user = remoteAuthDataSource.signUp(firstName, lastName, email, password)
        user?.let { localAuthDataSource.saveUser(it) }
        return user
    }

    override suspend fun forgotPassword(email: String): Boolean {
        return remoteAuthDataSource.forgotPassword(email)
    }
}