package com.example.klarnacodingchallenge.framework

import com.example.klarnacodingchallenge.data.datasource.WeatherRemoteDataSource
import com.example.klarnacodingchallenge.data.datasource.WeatherServiceApi
import com.example.klarnacodingchallenge.domain.WeatherInfoApiResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

class WeatherRemoteDataSourceImpl(
    private val weatherServiceApi: WeatherServiceApi,
    private val coroutineDispatcher: CoroutineDispatcher
) :
    WeatherRemoteDataSource {
    override fun getWeatherData(lat: Double, lng: Double): Flow<Response<WeatherInfoApiResponse>> =
        flow {
            emit(weatherServiceApi.getWeather(lat, lng))
        }.flowOn(coroutineDispatcher)
}