package com.example.klarnacodingchallenge.domain

import android.os.Parcelable
import com.example.klarnacodingchallenge.util.Constants.EMPTY
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Data contains hourly weather information
 */
@Parcelize
data class HourlyWeatherInfo(
    @SerializedName("summary") var summary: String? = EMPTY,
    @SerializedName("icon") var icon: String? = EMPTY,
    @SerializedName("data") var data: ArrayList<WeatherInfoData> = arrayListOf()
) : Parcelable
