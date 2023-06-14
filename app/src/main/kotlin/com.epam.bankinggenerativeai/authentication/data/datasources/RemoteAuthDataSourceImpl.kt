package com.epam.bankinggenerativeai.authentication.data.datasources

import com.epam.bankinggenerativeai.authentication.data.api.AuthApi
import com.epam.bankinggenerativeai.authentication.domain.entities.User
import javax.inject.Inject

class RemoteAuthDataSourceImpl @Inject constructor(private val authApi: AuthApi) : RemoteAuthDataSource {

    override suspend fun login(email: String, password: String): User? {
        val response = authApi.login(email, password)
        return if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
    }

    override suspend fun signUp(firstName: String, lastName: String, email: String, password: String): User? {
        val response = authApi.signUp(firstName, lastName, email, password)
        return if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
    }

    override suspend fun forgotPassword(email: String): Boolean {
        val response = authApi.forgotPassword(email)
        return response.isSuccessful
    }
}