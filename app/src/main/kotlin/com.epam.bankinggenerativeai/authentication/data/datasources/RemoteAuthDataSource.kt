package com.epam.bankinggenerativeai.authentication.data.datasources

import com.epam.bankinggenerativeai.authentication.domain.entities.User

interface RemoteAuthDataSource {

    /**
     * Authenticates a user with the given email and password.
     *
     * @param email The email address of the user.
     * @param password The password of the user.
     * @return The authenticated user if the credentials are valid, null otherwise.
     */
    suspend fun login(email: String, password: String): User?

    /**
     * Registers a new user with the given information.
     *
     * @param firstName The first name of the user.
     * @param lastName The last name of the user.
     * @param email The email address of the user.
     * @param password The password of the user.
     * @return The registered user if the registration is successful, null otherwise.
     */
    suspend fun signUp(firstName: String, lastName: String, email: String, password: String): User?

    /**
     * Sends a password reset email to the user with the given email address.
     *
     * @param email The email address of the user.
     * @return True if the password reset email was sent successfully, false otherwise.
     */
    suspend fun forgotPassword(email: String): Boolean
}