package com.mvp.cidade_organica.feature.login.data.model

import com.squareup.moshi.Json

data class LoginRequest(
    @Json(name = "email") val user: String,
    @Json(name = "password") val password: String
)

data class TokenResponse(
    @Json(name = "name") val name: String,
    @Json(name = "token") val token: String
)