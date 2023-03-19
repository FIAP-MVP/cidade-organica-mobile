package com.mvp.cidade_organica.feature.login.data

import com.mvp.cidade_organica.feature.login.data.model.LoggedInUser

class RegisterRepository(private val dataSource: RegisterDataSource) {
    var user: LoggedInUser? = null
        private set

    val isLoggedIn: Boolean
        get() = user != null

    init {
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
        user = null
    }

    fun logout() {
        user = null
        dataSource.logout()
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
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }
}