package com.mvp.cidade_organica.feature.login.ui

sealed class LoginResult {
    class Success(user: LoggedInUserView) : LoginResult()

    class Error(code: Int) : LoginResult()

    object Default : LoginResult()
}
