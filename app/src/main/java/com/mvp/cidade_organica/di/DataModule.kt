package com.mvp.cidade_organica.di

import com.mvp.cidade_organica.feature.login.data.LoginDataSource
import com.mvp.cidade_organica.feature.login.data.LoginRepository
import org.koin.dsl.module

object DataModule {

    val module = module {

        single<LoginRepository> {
            LoginRepository(dataSource = get())
        }

        single {
            LoginDataSource(api = get(), sharedPreferences = get())
        }
    }
}
