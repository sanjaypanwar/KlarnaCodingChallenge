package com.example.klarnacodingchallenge.domain

import android.os.Parcelable
import com.example.klarnacodingchallenge.util.Constants.EMPTY
import kotlinx.parcelize.Parcelize

/**
 * Daily weather info data
 */
@Parcelize
data class WeatherInfoDataDaily(
    val time: Long = Long.MIN_VALUE,
    val summary: String = EMPTY,
    val icon: String = EMPTY,
    val sunriseTime: Int = Int.MIN_VALUE,
    val sunsetTime: Int = Int.MIN_VALUE,
    val moonPhase: Double = Double.MIN_VALUE,
    val precipIntensity: Double = Double.MIN_VALUE,
    val precipIntensityMax: Double = Double.MIN_VALUE,
    val precipIntensityMaxTime: Int = Int.MIN_VALUE,
    val precipProbability: Double = Double.MIN_VALUE,
    val precipType: String = EMPTY,
    val precipAccumulation: Double = Double.MIN_VALUE,
    val temperatureHigh: Double = Double.MIN_VALUE,
    val temperatureHighTime: Int = Int.MIN_VALUE,
    val temperatureLow: Double = Double.MIN_VALUE,
    val temperatureLowTime: Int = Int.MIN_VALUE,
    val apparentTemperatureHigh: Int = Int.MIN_VALUE,
    val apparentTemperatureHighTime: Int = Int.MIN_VALUE,
    val apparentTemperatureLow: Double = Double.MIN_VALUE,
    val apparentTemperatureLowTime: Int = Int.MIN_VALUE,
    val dewPoint: Double = Double.MIN_VALUE,
    val humidity: Double = Double.MIN_VALUE,
    val pressure: Double = Double.MIN_VALUE,
    val windSpeed: Double = Double.MIN_VALUE,
    val windGust: Double = Double.MIN_VALUE,
    val windGustTime: Int = Int.MIN_VALUE,
    val windBearing: Int = Int.MIN_VALUE,
    val cloudCover: Double = Double.MIN_VALUE,
    val uvIndex: Int = Int.MIN_VALUE,
    val uvIndexTime: Int = Int.MIN_VALUE,
    val visibility: Double = Double.MIN_VALUE,
    val ozone: Double = Double.MIN_VALUE,
    val temperatureMin: Double = Double.MIN_VALUE,
    val temperatureMinTime: Int = Int.MIN_VALUE,
    val temperatureMax: Double = Double.MIN_VALUE,
    val temperatureMaxTime: Int = Int.MIN_VALUE,
    val apparentTemperatureMin: Double = Double.MIN_VALUE,
    val apparentTemperatureMinTime: Int = Int.MIN_VALUE,
    val apparentTemperatureMax: Int = Int.MIN_VALUE,
    val apparentTemperatureMaxTime: Int = Int.MIN_VALUE,
) : Parcelable
