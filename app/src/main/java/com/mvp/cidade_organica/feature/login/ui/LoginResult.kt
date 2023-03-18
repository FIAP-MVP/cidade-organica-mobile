package com.mvp.cidade_organica.feature.login.ui

import com.mvp.cidade_organica.feature.login.ui.LoggedInUserView

/**
 * Authentication result : success (user details) or error message.
 */
data class LoginResult(
    val success: LoggedInUserView? = null,
    val error: Int? = null
)