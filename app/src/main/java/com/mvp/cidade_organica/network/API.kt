package com.mvp.cidade_organica.network

import com.mvp.cidade_organica.Result
import com.mvp.cidade_organica.feature.login.data.model.LoginRequest
import com.mvp.cidade_organica.feature.login.data.model.TokenResponse
import com.mvp.cidade_organica.feature.signup.model.SignUpUser
import retrofit2.Response
import retrofit2.http.Body

import retrofit2.http.POST

interface API {

    @POST("auth/authenticate")
    suspend fun login(@Body loginRequest: LoginRequest): Response<TokenResponse>

    @POST("auth/register")
    suspend fun register(@Body user: SignUpUser): Response<TokenResponse>

}