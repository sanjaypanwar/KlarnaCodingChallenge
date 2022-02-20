package com.example.klarnacodingchallenge.di

import com.example.klarnacodingchallenge.data.datasource.WeatherRemoteDataSource
import com.example.klarnacodingchallenge.data.datasource.WeatherServiceApi
import com.example.klarnacodingchallenge.data.repository.IWeatherRepository
import com.example.klarnacodingchallenge.data.repository.WeatherDataMapper
import com.example.klarnacodingchallenge.data.repository.WeatherRepository
import com.example.klarnacodingchallenge.framework.WeatherDataMapperImpl
import com.example.klarnacodingchallenge.framework.WeatherRemoteDataSourceImpl
import com.example.klarnacodingchallenge.usercases.Interactors
import com.example.klarnacodingchallenge.usercases.WeatherUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

/**
 * Module class to provide dependencies for data layer.
 */
@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    /**
     * Coroutine dispatcher to be used by the coroutines call.
     */
    @Provides
    @Singleton
    fun providesDispatcher(): CoroutineDispatcher = Dispatchers.IO

    /**
     * Data source implementation for getting weather data
     */
    @Provides
    @Singleton
    fun providesWeatherDataSource(
        weatherServiceApi: WeatherServiceApi
    ): WeatherRemoteDataSource = WeatherRemoteDataSourceImpl(weatherServiceApi)

    /**
     * Data source implementation for getting weather data
     */
    @Provides
    @Singleton
    fun providesWeatherDataMapper(): WeatherDataMapper = WeatherDataMapperImpl()

    /**
     * Repository class for providing data
     */
    @Provides
    @Singleton
    fun providesWeatherRepository(
        weatherRemoteDataSource: WeatherRemoteDataSource,
        weatherDataMapper: WeatherDataMapper,
        dispatcher: CoroutineDispatcher
    ): IWeatherRepository = WeatherRepository(
        weatherRemoteDataSource,
        weatherDataMapper,
        dispatcher
    )

    @Provides
    @Singleton
    fun providesWeatherUseCase(weatherRepository: IWeatherRepository): WeatherUseCase =
        WeatherUseCase(weatherRepository)

    @Provides
    @Singleton
    fun providesInteractor(weatherUseCase: WeatherUseCase) = Interactors(weatherUseCase)

}