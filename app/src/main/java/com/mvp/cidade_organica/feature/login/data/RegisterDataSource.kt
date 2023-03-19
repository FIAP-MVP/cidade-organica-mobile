package com.mvp.cidade_organica.feature.login.data

import com.mvp.cidade_organica.feature.login.data.model.LoggedInUser
import com.mvp.cidade_organica.network.API
import java.io.IOException

class RegisterDataSource(private val api: API) {

    fun register(name: String, lastName: String, cpf : String, email : String, phone : String, password : String): Result<LoggedInUser> {
        return try {
            api.register(name, lastName, cpf, email, phone, password)
        } catch (e: Throwable) {
            Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
    }
}