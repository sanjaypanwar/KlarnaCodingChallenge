package com.example.klarnacodingchallenge.usercases

import com.example.klarnacodingchallenge.data.repository.IWeatherRepository

/**
 * Use case class for fetching weather data only
 */
class WeatherUseCase(private val weatherRepository: IWeatherRepository) {
    /**
     * Operator function which can be invoked directly by view model.
     */
    operator fun invoke(lat: Double, lng: Double) =
        weatherRepository.getWeatherForGeoLocation(lat, lng)
}