package com.example.klarnacodingchallenge.domain

import android.os.Parcelable
import com.example.klarnacodingchallenge.util.Constants.EMPTY
import kotlinx.parcelize.Parcelize

/**
 * Data contains hourly weather information
 */
@Parcelize
data class HourlyWeatherInfo(
    val summary: String = EMPTY,
    val icon: String = EMPTY,
    val data: List<WeatherInfoData> = listOf()
) : Parcelable
