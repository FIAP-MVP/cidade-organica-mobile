package com.mvp.cidade_organica.feature.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.mvp.cidade_organica.Navigation
import com.mvp.cidade_organica.feature.login.ui.SignInScreen
import com.mvp.cidade_organica.ui.theme.Cidade_OrganicaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Cidade_OrganicaTheme {

                Scaffold(content = { _ ->
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colors.background
                    ) {
                        val navController = rememberNavController()
                        Navigation(navController)
                    }
                })
            }
        }
    }
}