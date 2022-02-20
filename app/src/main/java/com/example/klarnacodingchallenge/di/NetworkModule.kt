package com.example.klarnacodingchallenge.di

import com.example.klarnacodingchallenge.BuildConfig
import com.example.klarnacodingchallenge.data.datasource.WeatherServiceApi
import com.example.klarnacodingchallenge.util.ApiConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Module class to provide dependencies for Retrofit api call.
 */
@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    /**
     * Provides OkHttp client to handle http calls
     */
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()
        } else {
            OkHttpClient
                .Builder()
                .build()
        }
    }

    /**
     * Retrofit instance
     */
    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(ApiConfig.BASE_URL)
            .client(okHttpClient)
            .build()

    /**
     * Weather api service to call api for weather data
     */
    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): WeatherServiceApi =
        retrofit.create(WeatherServiceApi::class.java)

}