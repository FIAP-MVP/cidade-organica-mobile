package com.mvp.cidade_organica.di

import com.mvp.cidade_organica.feature.login.data.LoginDataSource
import com.mvp.cidade_organica.feature.login.data.LoginRepository
import com.mvp.cidade_organica.feature.login.data.model.TokenRepository
import com.mvp.cidade_organica.feature.signup.data.RegisterDataSource
import com.mvp.cidade_organica.feature.signup.data.RegisterRepository
import com.mvp.cidade_organica.feature.store.data.StoreDataSource
import com.mvp.cidade_organica.feature.store.data.StoreRepository
import org.koin.dsl.module

object DataModule {

    val module = module {

        single {
            LoginRepository(dataSource = get())
        }

        single {
            LoginDataSource(api = get(), tokenRepository = get())
        }

        single {
            TokenRepository(sharedPreferences = get())
        }

        single {
            RegisterRepository(dataSource = get())
        }

        single {
            RegisterDataSource(api = get(), get())
        }

        single {
            StoreRepository(storeService = get())
        }

        single {
            StoreDataSource(api = get())
        }
    }
}
