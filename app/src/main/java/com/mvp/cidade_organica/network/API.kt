package com.mvp.cidade_organica.network

import com.mvp.cidade_organica.feature.login.data.model.LoggedInUser
import com.mvp.cidade_organica.Result
import com.mvp.cidade_organica.feature.login.data.model.LoginRequest
import com.mvp.cidade_organica.feature.login.data.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body

import retrofit2.http.POST

interface API {

    @POST("auth/authenticate")
    suspend fun login(@Body loginRequest: LoginRequest) : Response<LoginResponse>

    @POST("/auth/register")
    fun register(name: String, lastName: String, cpf: String, email: String, phone: String, password: String): Result<LoggedInUser>

}