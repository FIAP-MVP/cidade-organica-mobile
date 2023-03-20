package com.mvp.cidade_organica.feature.login.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mvp.cidade_organica.Screen
import org.koin.androidx.compose.getViewModel

@Composable
fun SignInScreen(viewModel: LoginViewModel = getViewModel(), navController: NavHostController) {
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


    when (val result = viewModel.loginResult.value) {

        is LoginResult.Error -> {
        }
        is LoginResult.Success -> {
            navController.navigate(
                Screen.Home.route.replace(
                    oldValue = "{user_name}",
                    newValue = result.user.displayName
                )
            )
        }
        else -> {}
    }
}
