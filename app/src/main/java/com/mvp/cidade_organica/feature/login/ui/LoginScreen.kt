package com.mvp.cidade_organica.feature.login.ui

import androidx.compose.runtime.Composable
import org.koin.androidx.compose.getViewModel

@Composable
fun LoginScreen(viewModel: LoginViewModel = getViewModel()){

    viewModel.login("joao", "dasNeves")

}