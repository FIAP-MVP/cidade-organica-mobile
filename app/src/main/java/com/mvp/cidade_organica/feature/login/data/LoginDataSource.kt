package com.mvp.cidade_organica.feature.login.data

import com.mvp.cidade_organica.feature.login.data.model.LoggedInUser
import com.mvp.cidade_organica.feature.login.data.model.LoginRequest
import com.mvp.cidade_organica.network.API
import java.io.IOException

class LoginDataSource(private val api: API) {

    suspend fun login(username: String, password: String): Result<LoggedInUser> {
        return try {
          val result = api.login(LoginRequest( username, password))
            Result.Success(LoggedInUser(userId = result.body()?.token ?: "", "USUARIO"))
        } catch (e: Throwable) {
            Result.Error(IOException("Error logging in", e))
        }
    }
}