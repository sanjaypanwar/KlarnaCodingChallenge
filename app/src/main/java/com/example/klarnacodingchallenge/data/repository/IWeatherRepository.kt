package com.example.klarnacodingchallenge.data.repository

import com.example.klarnacodingchallenge.domain.DataHolder
import com.example.klarnacodingchallenge.domain.WeatherPresenterData
import kotlinx.coroutines.flow.Flow

/**
 * Repository interface to interact with Use cases
 */
interface IWeatherRepository {
    fun getWeatherForGeoLocation(lat: Double, lng: Double): Flow<DataHolder<WeatherPresenterData>>
}