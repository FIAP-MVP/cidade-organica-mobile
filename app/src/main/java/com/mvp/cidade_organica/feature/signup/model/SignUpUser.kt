package com.mvp.cidade_organica.feature.signup.model

import com.squareup.moshi.Json

data class SignUpUser(
    @Json(name = "name") val name: String,
    @Json(name = "lastName") val lastName: String,
    @Json(name = "cpf") val document: String,
    @Json(name = "phone") val phone: String,
    @Json(name = "email") val email: String,
    @Json(name = "password") val password: String,
)
