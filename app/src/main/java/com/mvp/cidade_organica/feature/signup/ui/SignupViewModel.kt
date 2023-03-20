package com.mvp.cidade_organica.feature.signup.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mvp.cidade_organica.R
import com.mvp.cidade_organica.Result
import com.mvp.cidade_organica.feature.login.ui.LoggedInUserView
import com.mvp.cidade_organica.feature.login.ui.LoginResult
import com.mvp.cidade_organica.feature.signup.data.RegisterRepository
import com.mvp.cidade_organica.feature.signup.model.SignUpUser
import kotlinx.coroutines.launch

sealed class SignUpResult {
    class Success(user: LoggedInUserView) : SignUpResult()

    class Error(code: Int) : SignUpResult()

    object Default : SignUpResult()
}

class SignupViewModel(private val repository: RegisterRepository) : ViewModel() {
    private val _signUpResult = mutableStateOf<SignUpResult>(SignUpResult.Default)
    val signUpResult: State<SignUpResult> = _signUpResult

    fun doRegister(user: SignUpUser) {
        viewModelScope.launch {
            val result = repository.register(user)

            if (result is Result.Success) {
                _signUpResult.value =
                    SignUpResult.Success(LoggedInUserView(displayName = result.data.displayName))
            } else {
                _signUpResult.value = SignUpResult.Error(R.string.login_failed)
            }
        }
    }
}

