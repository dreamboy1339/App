package com.hjw.di

import com.hjw.network.api.MusinsaApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

private const val APPLICATION_JSON = "application/json"

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val BASE_URL = "https://meta.musinsa.com"
    private const val TIMEOUT = 10L

    @Provides
    fun provideOkhttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .apply {
                if (BuildConfig.DEBUG) {
                    val loggingInterceptor = HttpLoggingInterceptor().apply {
                        setLevel(HttpLoggingInterceptor.Level.BODY)
                    }
                    addInterceptor(loggingInterceptor)
                }
            }
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofitClient(
        okHttpClient: OkHttpClient,
    ): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(Json.asConverterFactory(APPLICATION_JSON.toMediaType()))
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): MusinsaApi {
        return retrofit.create(MusinsaApi::class.java)
    }
}
