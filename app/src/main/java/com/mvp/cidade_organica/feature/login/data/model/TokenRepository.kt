package com.mvp.cidade_organica.feature.login.data.model

import android.content.SharedPreferences

const val TOKEN_KEY = "PSW"
class TokenRepository(private val sharedPreferences: SharedPreferences) {

    fun storeToken(token: String) {
        with(sharedPreferences.edit()) {
            putString(TOKEN_KEY, token)
            apply()
        }
    }

    fun retrieveToken() = sharedPreferences.getString(TOKEN_KEY, null)

    fun clearToken() {
        with(sharedPreferences.edit()) {
            remove("PSW")
            apply()
        }
    }
}