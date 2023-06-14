package com.epam.bankinggenerativeai.authentication.data.datasources

import com.epam.bankinggenerativeai.authentication.domain.entities.User

interface LocalAuthDataSource {

    /**
     * Saves the authenticated user to local storage.
     *
     * @param user The authenticated user.
     */
    suspend fun saveUser(user: User)

    /**
     * Retrieves the authenticated user from local storage.
     *
     * @return The authenticated user if available, null otherwise.
     */
    suspend fun getUser(): User?

    /**
     * Deletes the authenticated user from local storage.
     */
    suspend fun deleteUser()
}