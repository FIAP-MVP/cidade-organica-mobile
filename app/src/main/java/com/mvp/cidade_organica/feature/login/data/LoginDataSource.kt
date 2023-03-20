package com.mvp.cidade_organica.feature.login.data

import com.mvp.cidade_organica.Result
import com.mvp.cidade_organica.feature.login.data.model.LoggedInUser
import com.mvp.cidade_organica.feature.login.data.model.LoginRequest
import com.mvp.cidade_organica.feature.login.data.model.TokenResponse
import com.mvp.cidade_organica.feature.login.data.model.TokenRepository
import com.mvp.cidade_organica.network.API
import retrofit2.Response
import java.io.IOException

class LoginDataSource(private val api: API, private val tokenRepository: TokenRepository) {

    suspend fun login(username: String, password: String): Result<LoggedInUser> {
        return try {
            val result = api.login(LoginRequest(username, password))
            saveUserToken(result)
            Result.Success(LoggedInUser(userId = "abc123", "USUARIO"))
        } catch (e: Throwable) {
            Result.Error(IOException("Error logging in", e))
        }
    }

    private fun saveUserToken(result: Response<TokenResponse>) {
        result.body()?.token?.let { tokenRepository.storeToken(it) }
    }
}