package com.mvp.cidade_organica.feature.signup.data

import com.mvp.cidade_organica.Result
import com.mvp.cidade_organica.feature.login.data.model.LoggedInUser
import com.mvp.cidade_organica.feature.signup.model.SignUpUser

class RegisterRepository(private val dataSource: RegisterDataSource) {

    suspend fun register(name: SignUpUser): Result<LoggedInUser> {
        return dataSource.register(name)
    }
}