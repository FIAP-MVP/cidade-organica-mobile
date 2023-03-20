package com.mvp.cidade_organica.feature.signup.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Surface
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
import com.mvp.cidade_organica.feature.signup.ui.SignUpDefaults.DOCUMENT_MASK
import com.mvp.cidade_organica.feature.signup.ui.SignUpDefaults.INPUT_LENGTH
import com.mvp.cidade_organica.feature.signup.ui.SignUpDefaults.PHONE_MASK
import com.mvp.cidade_organica.ui.theme.Teal200

@Composable
fun SignUpScreen(navController: NavHostController) {
    var firstNameValue by remember { mutableStateOf(TextFieldValue("")) }
    var lastNameValue by remember { mutableStateOf(TextFieldValue("")) }
    var documentValue by remember { mutableStateOf(TextFieldValue("")) }
    var phoneValue by remember { mutableStateOf(TextFieldValue("")) }
    var emailValue by remember { mutableStateOf(TextFieldValue("")) }
    var passwordValue by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {

        TextField(
            value = firstNameValue,
            onValueChange = { firstNameValue = it },
            label = { Text("Primeiro Nome") },
            placeholder = { Text(text = "ex: João") },
            modifier = Modifier
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Text
            )
        )
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = lastNameValue,
            onValueChange = { lastNameValue = it },
            label = { Text("Último nome") },
            placeholder = { Text(text = "ex: Silva") },
            modifier = Modifier
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Text
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = documentValue,
            onValueChange = { it ->
                if (it.text.length <= INPUT_LENGTH) {
                    it.text.filter { it.isDigit() }.apply {
                        documentValue = it
                    }
                }
            },
            label = { Text("CPF") },
            visualTransformation = MaskVisualTransformation(DOCUMENT_MASK),
            modifier = Modifier
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Number
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = phoneValue,
            onValueChange = { it ->
                if (it.text.length <= INPUT_LENGTH) {
                    it.text.filter { it.isDigit() }.apply {
                        phoneValue = it
                    }
                }
            },
            label = { Text("Telefone") },
            visualTransformation = MaskVisualTransformation(PHONE_MASK),
            modifier = Modifier
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Phone
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        Surface(color = Teal200) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Credenciais")

                Spacer(modifier = Modifier.height(16.dp))

                TextField(
                    value = emailValue,
                    onValueChange = { emailValue = it },
                    label = { Text("E-mail") },
                    placeholder = { Text(text = "exemplo@email.com") },
                    modifier = Modifier
                        .fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(12.dp))

                TextField(
                    value = passwordValue,
                    label = { Text("Senha") },
                    modifier = Modifier
                        .fillMaxWidth(),
                    visualTransformation = PasswordVisualTransformation(),
                    onValueChange = { passwordValue = it },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Done,
                        keyboardType = KeyboardType.Password
                    )
                )

            }
        }
        Spacer(modifier = Modifier.height(48.dp))

        Button(modifier = Modifier
            .height(42.dp)
            .fillMaxWidth(),
            onClick = {}) {
            Text(text = "Cadastrar")
        }
    }
}

object SignUpDefaults {
    const val DOCUMENT_MASK = "###.###.###-##"
    const val PHONE_MASK = "(##) #####-####"
    const val INPUT_LENGTH = 11
}

