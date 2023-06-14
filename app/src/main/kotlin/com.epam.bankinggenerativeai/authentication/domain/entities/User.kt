package com.epam.bankinggenerativeai.authentication.domain.entities

/**
 * Represents a user in the banking app.
 *
 * @property id The unique identifier of the user.
 * @property firstName The first name of the user.
 * @property lastName The last name of the user.
 * @property email The email address of the user.
 * @property passwordHash The hashed password of the user.
 * @property phoneNumber The phone number of the user.
 * @property createdAt The timestamp when the user was created.
 * @property updatedAt The timestamp when the user was last updated.
 */
data class User(
    val id: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val passwordHash: String,
    val phoneNumber: String,
    val createdAt: Long,
    val updatedAt: Long
)