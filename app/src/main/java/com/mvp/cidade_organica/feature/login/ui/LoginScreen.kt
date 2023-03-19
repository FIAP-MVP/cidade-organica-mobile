package com.mvp.cidade_organica.feature.login.ui

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.InternalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.getViewModel

@Composable
fun LoginScreen(viewModel: LoginViewModel = getViewModel()) {
    var usernameValue by remember { mutableStateOf(TextFieldValue("")) }
    var passwordValue by remember { mutableStateOf(TextFieldValue("")) }
    Column(modifier = Modifier.padding(16.dp)) {

        TextField(
            value = usernameValue,
            onValueChange = { usernameValue = it },
            label = { Text("Usuário") },
            placeholder = { Text(text = "exemplo@email.com") },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(12.dp))

        TextField(
            value = passwordValue,
            label = { Text("Senha") },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(),
            onValueChange = { passwordValue = it },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Password
            )
        )

        Spacer(modifier = Modifier.height(24.dp))
        Button(modifier = Modifier
            .height(42.dp)
            .fillMaxWidth(),
            onClick = { viewModel.login(usernameValue.text, passwordValue.text) }) {
            Text(text = "Login")
        }
    }

    when (viewModel.loginResult.value) {

        is LoginResult.Error -> {
            Snackbar(
                content = { Text(text = "Falhou") },
                action = {
                    Text(text = "OK",
                        style = TextStyle(color = MaterialTheme.colors.secondary)
                    )
                }
            )
        }
        is LoginResult.Success -> {
            Snackbar(
                content = { Text(text = "Sucesso") },
                action = {
                    Text(text = "OK",
                        style = TextStyle(color = MaterialTheme.colors.secondary)
                    )
                }
            )
        }
        else -> {}
    }
}


@Preview
@Composable
fun preview() {
    LoginScreen()
}