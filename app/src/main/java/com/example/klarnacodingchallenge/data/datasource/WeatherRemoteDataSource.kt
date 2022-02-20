package com.example.klarnacodingchallenge.data.datasource

import com.example.klarnacodingchallenge.domain.WeatherInfoApiResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface WeatherRemoteDataSource {
    fun getWeatherData(lat: Double, lng: Double): Flow<Response<WeatherInfoApiResponse>>
}