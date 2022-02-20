package com.example.klarnacodingchallenge.domain

import android.os.Parcelable
import com.example.klarnacodingchallenge.util.Constants.EMPTY
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Weather info data to store the hourly data
 */
@Parcelize
data class WeatherInfoData(
    @SerializedName("time") var time: Long? = Long.MIN_VALUE,
    @SerializedName("summary") var summary: String? = EMPTY,
    @SerializedName("icon") var icon: String? = EMPTY,
    @SerializedName("temperature") var temperature: Double? = Double.MIN_VALUE,
    @SerializedName("apparentTemperature") var apparentTemperature: Double? = Double.MIN_VALUE,
    @SerializedName("dewPoint") var dewPoint: Double? = Double.MIN_VALUE,
    @SerializedName("humidity") var humidity: Double? = Double.MIN_VALUE,
    @SerializedName("pressure") var pressure: Double? = Double.MIN_VALUE,
    @SerializedName("windSpeed") var windSpeed: Double? = Double.MIN_VALUE,
    @SerializedName("windGust") var windGust: Double? = Double.MIN_VALUE,
    @SerializedName("windBearing") var windBearing: Int? = Int.MIN_VALUE,
    @SerializedName("cloudCover") var cloudCover: Double? = Double.MIN_VALUE,
    @SerializedName("uvIndex") var uvIndex: Int? = Int.MIN_VALUE,
) : Parcelable
