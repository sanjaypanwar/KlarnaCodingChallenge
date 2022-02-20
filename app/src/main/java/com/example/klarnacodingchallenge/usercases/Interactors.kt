package com.example.klarnacodingchallenge.usercases

/**
 * Class through which view model can interact and call the use case methods
 */
data class Interactors(val getWeatherData: WeatherUseCase)