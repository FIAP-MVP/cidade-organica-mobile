package com.mvp.cidade_organica

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mvp.cidade_organica.feature.login.ui.SignInScreen
import com.mvp.cidade_organica.feature.signup.SignUpScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.SignUp.route) {
        composable(route = Screen.SignIn.route) { SignInScreen(navController = navController) }
        composable(route = Screen.SignUp.route) { SignUpScreen(navController = navController) }
        composable(route = Screen.Home.route) { SignUpScreen(navController = navController) }
    }
}

sealed class Screen(val route: String) {
    object SignIn : Screen("sign_in")
    object SignUp : Screen("sign_up")
    object Home : Screen("home")
}
