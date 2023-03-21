package com.mvp.cidade_organica

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.mvp.cidade_organica.feature.home.HomeScreen
import com.mvp.cidade_organica.feature.login.ui.SignInScreen
import com.mvp.cidade_organica.feature.signup.ui.SignUpScreen
import com.mvp.cidade_organica.feature.store.list.ui.SellerListScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.Store.route) {
        composable(route = Screen.SignIn.route) { SignInScreen(navController = navController) }
        composable(route = Screen.SignUp.route) { SignUpScreen(navController = navController) }
        composable(route = Screen.Store.route) { SellerListScreen(navController = navController) }
        composable(
            route = Screen.Home.route, // trocar para user ID no futuro e fazer request para buscar dados
            arguments = listOf(
                navArgument("user_name") {
                    defaultValue = ""
                    type = NavType.StringType
                }
            )
        ) { navBackStackEntry ->
            val userName = navBackStackEntry.arguments?.getString("user_name")
            userName?.let {
                HomeScreen(userName = it, navController = navController)
            }
        }
    }
}

sealed class Screen(val route: String) {
    object SignIn : Screen("sign_in")
    object SignUp : Screen("sign_up")
    object Home : Screen("home?user_name={user_name}")
    object Store : Screen("store")
}
