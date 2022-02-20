package com.example.klarnacodingchallenge.data.datasource

import com.example.klarnacodingchallenge.domain.WeatherInfoApiResponse
import com.example.klarnacodingchallenge.util.ApiConfig
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherServiceApi {

    @GET(ApiConfig.FORECAST + "{lat},{lng}")
    suspend fun getWeather(
        @Path("lat") lat: Double,
        @Path("lng") lng: Double
    ): Response<WeatherInfoApiResponse>

}
