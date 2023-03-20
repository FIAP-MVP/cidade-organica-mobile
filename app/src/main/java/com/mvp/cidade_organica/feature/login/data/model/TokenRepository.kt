package com.mvp.cidade_organica.feature.login.data.model

import android.content.SharedPreferences

class TokenRepository(private val sharedPreferences: SharedPreferences) {

    fun storeToken(token: String) {
        with(sharedPreferences.edit()) {
            putString("PSW", token)
            apply()
        }
    }

    fun clearToken() {
        with(sharedPreferences.edit()) {
            remove("PSW")
            apply()
        }
    }
}