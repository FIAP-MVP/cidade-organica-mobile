package com.mvp.cidade_organica.feature.login.data

import com.mvp.cidade_organica.feature.login.data.model.LoggedInUser
import com.mvp.cidade_organica.network.API
import java.io.IOException

class LoginDataSource(private val api: API) {

    fun login(username: String, password: String): Result<LoggedInUser> {
        return try {
            api.login(username, password)
        } catch (e: Throwable) {
            Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
    }
}