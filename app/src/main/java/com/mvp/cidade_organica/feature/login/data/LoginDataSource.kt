package com.mvp.cidade_organica.feature.login.data

import android.content.SharedPreferences
import com.mvp.cidade_organica.Result
import com.mvp.cidade_organica.feature.login.data.model.LoggedInUser
import com.mvp.cidade_organica.feature.login.data.model.LoginRequest
import com.mvp.cidade_organica.feature.login.data.model.LoginResponse
import com.mvp.cidade_organica.network.API
import retrofit2.Response
import java.io.IOException

class LoginDataSource(private val api: API, private val sharedPreferences: SharedPreferences ) {

    suspend fun login(username: String, password: String): Result<LoggedInUser> {
        return try {
          val result = api.login(LoginRequest( username, password))
            storeToken(result)
            Result.Success(LoggedInUser(userId = "abc123", "USUARIO"))
        } catch (e: Throwable) {
            Result.Error(IOException("Error logging in", e))
        }
    }

    private fun storeToken(result: Response<LoginResponse>) {
        with(sharedPreferences.edit()) {
            putString("PSW", result.body()?.token)
            apply()
        }
    }
}