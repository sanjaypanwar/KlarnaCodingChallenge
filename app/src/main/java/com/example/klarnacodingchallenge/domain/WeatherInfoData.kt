package com.example.klarnacodingchallenge.domain

import android.os.Parcelable
import com.example.klarnacodingchallenge.util.Constants.EMPTY
import kotlinx.parcelize.Parcelize

/**
 * Weather info data to store the hourly data
 */
@Parcelize
data class WeatherInfoData(
    val time: Int = Int.MIN_VALUE,
    val summary: String = EMPTY,
    val icon: String = EMPTY,
    val precipIntensity: Int = Int.MIN_VALUE,
    val precipProbability: Int = Int.MIN_VALUE,
    val temperature: Double = Double.MIN_VALUE,
    val apparentTemperature: Double = Double.MIN_VALUE,
    val dewPoint: Double = Double.MIN_VALUE,
    val humidity: Double = Double.MIN_VALUE,
    val pressure: Int = Int.MIN_VALUE,
    val windSpeed: Double = Double.MIN_VALUE,
    val windGust: Double = Double.MIN_VALUE,
    val windBearing: Int = Int.MIN_VALUE,
    val cloudCover: Double = Double.MIN_VALUE,
    val uvIndex: Int = Int.MIN_VALUE,
    val visibility: Int = Int.MIN_VALUE,
    val ozone: Double = Double.MIN_VALUE
) : Parcelable
