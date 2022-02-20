package com.example.klarnacodingchallenge.domain

import android.os.Parcelable
import com.example.klarnacodingchallenge.util.Constants
import kotlinx.parcelize.Parcelize

/**
 * Data to represent the UI screen to show information
 */
@Parcelize
data class WeatherPresenterData(
    val timezone: String = Constants.EMPTY,
    val currentWeather: WeatherUIInfo = WeatherUIInfo(),
    val hourlyDataSummary: String = Constants.EMPTY,
    val hourlyDataIcon: String = Constants.EMPTY,
    val hourlyWeatherDataList: List<WeatherUIInfo> = listOf(),
    val dailyDataSummary: String = Constants.EMPTY,
    val dailyDataIcon: String = Constants.EMPTY,
    val dailyWeatherDataList: List<WeatherUIInfo> = listOf(),
) : Parcelable

/**
 * Data to show the basic weather info tile
 */
@Parcelize
data class WeatherUIInfo(
    val timeTextValue: String = Constants.EMPTY,
    val dayOfWeek: String = Constants.EMPTY,
    val summary: String = Constants.EMPTY,
    val icon: String = Constants.EMPTY,
    val temperature: Int = Int.MIN_VALUE,
    val temperatureMin: Int = Int.MIN_VALUE,
    val temperatureMax: Int = Int.MIN_VALUE,
    val humidityPercentage: Int = Int.MIN_VALUE,
) : Parcelable