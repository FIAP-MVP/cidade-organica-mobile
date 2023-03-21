package com.mvp.cidade_organica.di

import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.mvp.cidade_organica.BuildConfig
import com.mvp.cidade_organica.feature.login.data.model.TokenRepository
import com.mvp.cidade_organica.network.API
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object AppModule {
    val module = module {
        single<Retrofit> {
            Retrofit.Builder()
                .baseUrl(BuildConfig.SERVER_URL)
                .addConverterFactory(MoshiConverterFactory.create(get()))
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .client(get())
                .build()
        }

        single {
            Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
        }

        single {
            val interceptor = HttpLoggingInterceptor().apply {
                level =
                    if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            }
            OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor { chain: Interceptor.Chain ->
                    val request = chain.request().newBuilder()
                        .header(
                            name = "Authorization",
                            value = "Bearer ".plus((get() as TokenRepository).retrieveToken())
                        )
                        .build()
                    chain.proceed(request)
                }
                .build()
        }

        single<API> {
            (get() as Retrofit).create(API::class.java)
        }
        single<SharedPreferences> {
            EncryptedSharedPreferences.create(
                "auth.txt",
                MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC),
                androidApplication(),
                EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            )
        }
    }
}