package com.mvp.cidade_organica.feature.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mvp.cidade_organica.Screen

@Composable
fun HomeScreen(userName: String? = null, navController: NavHostController) {

    if (!userName.isNullOrEmpty() ) {
        Text(text = "Olá $userName! Em breve mais novidades para você")
    } else {
        Column(modifier = Modifier.fillMaxWidth()) {
            Button(onClick = {
                navController.navigate(Screen.SignIn.route)
            }) {
                Text(text = "Faça seu login")
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(onClick = {
                navController.navigate(Screen.SignIn.route)
            }) {
                Text(text = "Faça seu Cadastro")
            }
        }
    }
}
