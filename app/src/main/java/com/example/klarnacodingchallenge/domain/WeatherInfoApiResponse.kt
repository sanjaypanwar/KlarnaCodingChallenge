package com.example.klarnacodingchallenge.domain

import android.os.Parcelable
import com.example.klarnacodingchallenge.util.Constants.EMPTY
import kotlinx.parcelize.Parcelize

/**
 * Response data from the api call of weather info
 */
@Parcelize
data class WeatherInfoApiResponse(
    val latitude: Double = Double.MAX_VALUE,
    val longitude: Double = Double.MIN_VALUE,
    val timezone: String = EMPTY,
    val currently: WeatherInfoData,
    val hourly: HourlyWeatherInfo,
    val daily: DailyWeatherInfo,
    val offset: Int
) : Parcelable
