package com.example.klarnacodingchallenge.domain

import android.os.Parcelable
import com.example.klarnacodingchallenge.util.Constants.EMPTY
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Response data from the api call of weather info
 */
@Parcelize
data class WeatherInfoApiResponse(
    @SerializedName("latitude") val latitude: Double? = Double.MAX_VALUE,
    @SerializedName("longitude") val longitude: Double? = Double.MIN_VALUE,
    @SerializedName("timezone") val timezone: String? = EMPTY,
    @SerializedName("currently") val currently: WeatherInfoData? = WeatherInfoData(),
    @SerializedName("hourly") val hourly: HourlyWeatherInfo? = HourlyWeatherInfo(),
    @SerializedName("daily") val daily: DailyWeatherInfo? = DailyWeatherInfo(),
) : Parcelable
