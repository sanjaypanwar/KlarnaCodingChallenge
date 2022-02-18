package com.example.klarnacodingchallenge.domain

import android.os.Parcelable
import com.example.klarnacodingchallenge.util.Constants
import kotlinx.parcelize.Parcelize

/**
 * Daily Weather Info
 */
@Parcelize
data class DailyWeatherInfo(
    val summary: String = Constants.EMPTY,
    val icon: String = Constants.EMPTY,
    val data: List<WeatherInfoDataDaily> = listOf()
) : Parcelable
