package com.example.klarnacodingchallenge.domain

import android.os.Parcelable
import com.example.klarnacodingchallenge.util.Constants.EMPTY
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Daily Weather Info
 */
@Parcelize
data class DailyWeatherInfo(
    @SerializedName("summary") var summary: String? = EMPTY,
    @SerializedName("icon") var icon: String? = EMPTY,
    @SerializedName("data") var data: ArrayList<WeatherInfoDataDaily> = arrayListOf()
) : Parcelable
