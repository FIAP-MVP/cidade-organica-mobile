package com.mvp.cidade_organica.di

import com.mvp.cidade_organica.feature.login.ui.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object PresentationModule {
    val module = module {
        viewModel {
            LoginViewModel(loginRepository = get())
        }
    }
}