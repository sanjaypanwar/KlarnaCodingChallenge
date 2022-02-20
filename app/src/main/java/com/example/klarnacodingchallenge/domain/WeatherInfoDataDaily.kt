package com.example.klarnacodingchallenge.domain

import android.os.Parcelable
import com.example.klarnacodingchallenge.util.Constants.EMPTY
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Daily weather info data
 */
@Parcelize
data class WeatherInfoDataDaily(
    @SerializedName("time") var time: Long? = Long.MIN_VALUE,
    @SerializedName("summary") var summary: String? = EMPTY,
    @SerializedName("icon") var icon: String? = EMPTY,
    @SerializedName("temperatureHigh") var temperatureHigh: Double? = Double.MIN_VALUE,
    @SerializedName("temperatureHighTime") var temperatureHighTime: Int? = Int.MIN_VALUE,
    @SerializedName("temperatureLow") var temperatureLow: Double? = Double.MIN_VALUE,
    @SerializedName("temperatureLowTime") var temperatureLowTime: Int? = Int.MIN_VALUE,
    @SerializedName("apparentTemperatureHigh") var apparentTemperatureHigh: Double? = Double.MIN_VALUE,
    @SerializedName("apparentTemperatureLow") var apparentTemperatureLow: Double? = Double.MIN_VALUE,
    @SerializedName("apparentTemperatureLowTime") var apparentTemperatureLowTime: Int? = Int.MIN_VALUE,
    @SerializedName("dewPoint") var dewPoint: Double? = Double.MIN_VALUE,
    @SerializedName("humidity") var humidity: Double? = Double.MIN_VALUE,
    @SerializedName("pressure") var pressure: Double? = Double.MIN_VALUE,
    @SerializedName("windSpeed") var windSpeed: Double? = Double.MIN_VALUE,
    @SerializedName("windGust") var windGust: Double? = Double.MIN_VALUE,
    @SerializedName("temperatureMin") var temperatureMin: Double? = Double.MIN_VALUE,
    @SerializedName("temperatureMinTime") var temperatureMinTime: Int? = Int.MIN_VALUE,
    @SerializedName("temperatureMax") var temperatureMax: Double? = Double.MIN_VALUE,
    @SerializedName("apparentTemperatureMin") var apparentTemperatureMin: Double? = Double.MIN_VALUE,
    @SerializedName("apparentTemperatureMinTime") var apparentTemperatureMinTime: Int? = Int.MIN_VALUE,
    @SerializedName("apparentTemperatureMax") var apparentTemperatureMax: Double? = Double.MIN_VALUE,
    @SerializedName("apparentTemperatureMaxTime") var apparentTemperatureMaxTime: Int? = Int.MIN_VALUE
) : Parcelable
