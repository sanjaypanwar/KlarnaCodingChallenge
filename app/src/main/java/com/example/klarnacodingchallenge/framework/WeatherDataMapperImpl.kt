package com.example.klarnacodingchallenge.framework

import com.example.klarnacodingchallenge.data.repository.WeatherDataMapper
import com.example.klarnacodingchallenge.domain.*
import com.example.klarnacodingchallenge.util.Constants.EMPTY
import com.example.klarnacodingchallenge.util.DateUtil
import com.example.klarnacodingchallenge.util.convertFahrenheitToCelsius
import kotlin.math.roundToInt

class WeatherDataMapperImpl : WeatherDataMapper {
    override fun mapWeatherAPIData(
        weatherAPIData: WeatherInfoApiResponse
    ): WeatherPresenterData =
        WeatherPresenterData(
            weatherAPIData.timezone ?: EMPTY,
            weatherAPIData.currently?.let { mapWeatherHourlyData(weatherAPIData.currently) }
                ?: WeatherUIInfo(),
            weatherAPIData.hourly?.summary ?: EMPTY,
            weatherAPIData.hourly?.icon ?: EMPTY,
            weatherAPIData.hourly?.data?.map {
                mapWeatherHourlyData(it)
            } ?: listOf(),
            weatherAPIData.daily?.summary ?: EMPTY,
            weatherAPIData.daily?.icon ?: EMPTY,
            weatherAPIData.daily?.data?.map {
                mapWeatherDailyData(it)
            } ?: listOf()
        )

    private fun mapWeatherDailyData(
        weatherInfoData: WeatherInfoDataDaily
    ): WeatherUIInfo = WeatherUIInfo(
        weatherInfoData.time?.let { DateUtil.weatherInfoData(it) } ?: EMPTY,
        weatherInfoData.time?.let { DateUtil.dayOfWeek(it) } ?: EMPTY,
        weatherInfoData.summary ?: EMPTY,
        weatherInfoData.icon ?: EMPTY,
        weatherInfoData.apparentTemperatureLow?.convertFahrenheitToCelsius() ?: Int.MIN_VALUE,
        weatherInfoData.temperatureMin?.convertFahrenheitToCelsius() ?: Int.MIN_VALUE,
        weatherInfoData.temperatureMax?.convertFahrenheitToCelsius() ?: Int.MIN_VALUE,
        weatherInfoData.humidity?.times(100)?.roundToInt() ?: Int.MIN_VALUE,
    )

    private fun mapWeatherHourlyData(
        weatherInfoData: WeatherInfoData
    ): WeatherUIInfo = WeatherUIInfo(
        weatherInfoData.time?.let { DateUtil.weatherInfoData(it) } ?: EMPTY,
        weatherInfoData.time?.let { DateUtil.dayOfWeek(it) } ?: EMPTY,
        weatherInfoData.summary ?: EMPTY,
        weatherInfoData.icon ?: EMPTY,
        weatherInfoData.temperature?.convertFahrenheitToCelsius() ?: Int.MIN_VALUE,
        humidityPercentage = weatherInfoData.humidity?.times(100)?.roundToInt() ?: Int.MIN_VALUE
    )
}