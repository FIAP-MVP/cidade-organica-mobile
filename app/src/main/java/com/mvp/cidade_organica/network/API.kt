package com.mvp.cidade_organica.network

import com.mvp.cidade_organica.feature.login.data.model.LoggedInUser
import com.mvp.cidade_organica.feature.login.data.Result

import retrofit2.http.POST

interface API {

    @POST("/auth/authenticate")
    fun login(username: String, password: String) : Result<LoggedInUser>

    @POST("/auth/register")
    fun register(name: String, lastName: String, cpf: String, email: String, phone: String, password: String): Result<LoggedInUser>

}