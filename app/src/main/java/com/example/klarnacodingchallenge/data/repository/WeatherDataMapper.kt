package com.example.klarnacodingchallenge.data.repository

import com.example.klarnacodingchallenge.domain.WeatherInfoApiResponse
import com.example.klarnacodingchallenge.domain.WeatherPresenterData

interface WeatherDataMapper {
    fun mapWeatherAPIData(weatherAPIData: WeatherInfoApiResponse): WeatherPresenterData
}