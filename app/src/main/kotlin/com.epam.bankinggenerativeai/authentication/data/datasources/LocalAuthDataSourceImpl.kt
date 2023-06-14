package com.epam.bankinggenerativeai.authentication.data.datasources

import android.content.Context
import android.content.SharedPreferences
import com.epam.bankinggenerativeai.authentication.domain.entities.User
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class LocalAuthDataSourceImpl @Inject constructor(@ApplicationContext private val context: Context) :
    LocalAuthDataSource {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
    private val gson = Gson()

    override suspend fun saveUser(user: User) {
        val userJson = gson.toJson(user)
        sharedPreferences.edit().putString(KEY_USER, userJson).apply()
    }

    override suspend fun getUser(): User? {
        val userJson = sharedPreferences.getString(KEY_USER, null)
        return if (userJson != null) {
            gson.fromJson(userJson, User::class.java)
        } else {
            null
        }
    }

    override suspend fun deleteUser() {
        sharedPreferences.edit().remove(KEY_USER).apply()
    }

    companion object {
        private const val PREFERENCES_NAME = "auth_preferences"
        private const val KEY_USER = "user"
    }
}