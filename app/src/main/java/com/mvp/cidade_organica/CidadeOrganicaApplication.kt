package com.mvp.cidade_organica

import android.app.Application
import com.mvp.cidade_organica.di.AppModule
import com.mvp.cidade_organica.di.DataModule
import com.mvp.cidade_organica.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class CidadeOrganicaApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(this@CidadeOrganicaApplication)
            modules(AppModule.module,
            PresentationModule.module,
            DataModule.module)
        }
    }
}