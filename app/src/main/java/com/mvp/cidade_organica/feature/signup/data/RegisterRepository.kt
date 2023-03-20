package com.mvp.cidade_organica.feature.signup.data

import com.mvp.cidade_organica.Result
import com.mvp.cidade_organica.feature.login.data.model.LoggedInUser

class RegisterRepository(private val dataSource: RegisterDataSource) {


    fun logout() {
        user = null
    }

    fun register(name: String, lastName: String, cpf : String, email : String, phone : String, password : String): Result<LoggedInUser> {
        val result = dataSource.register(name, lastName, cpf, email, phone, password)

        if (result is Result.Success) {
            setLoggedInUser(result.data)
        }

        return result
    }

    private fun setLoggedInUser(loggedInUser: LoggedInUser) {
        this.user = loggedInUser
    }
}