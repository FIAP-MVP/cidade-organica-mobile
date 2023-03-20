package com.mvp.cidade_organica.feature.login.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Patterns
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.mvp.cidade_organica.R
import com.mvp.cidade_organica.feature.login.data.LoginRepository
import com.mvp.cidade_organica.Result
import kotlinx.coroutines.launch

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm

    private val _loginResult = mutableStateOf<LoginResult>(LoginResult.Default)
    val loginResult: State<LoginResult> = _loginResult

    fun login(username: String, password: String) {
        if (validateCredentials(username, password)) {
            viewModelScope.launch {
                val result = loginRepository.login(username, password)

                if (result is Result.Success) {
                    _loginResult.value =
                        LoginResult.Success(LoggedInUserView(displayName = result.data.displayName))
                } else {
                    _loginResult.value = LoginResult.Error(R.string.login_failed)
                }
            }
        }
    }

    private fun validateCredentials(username: String, password: String): Boolean {
        return if (!isUserNameValid(username)) {
            _loginForm.value = LoginFormState(usernameError = R.string.invalid_username)
            false
        } else if (!isPasswordValid(password)) {
            _loginForm.value = LoginFormState(passwordError = R.string.invalid_password)
            false
        } else {
            _loginForm.value = LoginFormState(isDataValid = true)
            true

        }
    }

    private fun isUserNameValid(username: String): Boolean {
        return if (username.contains('@')) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            username.isNotBlank()
        }
    }

    private fun isPasswordValid(password: String): Boolean {
        return password.length >= 5
    }
}