package com.example.klarnacodingchallenge.framework

import com.example.klarnacodingchallenge.data.repository.WeatherDataMapper
import com.example.klarnacodingchallenge.domain.*
import com.example.klarnacodingchallenge.util.DateUtil
import kotlin.math.roundToInt

class WeatherDataMapperImpl : WeatherDataMapper {
    override fun mapWeatherAPIData(
        weatherAPIData: WeatherInfoApiResponse
    ): WeatherPresenterData =
        WeatherPresenterData(
            weatherAPIData.timezone,
            mapWeatherHourlyData(weatherAPIData.currently),
            weatherAPIData.hourly.summary,
            weatherAPIData.hourly.icon,
            weatherAPIData.hourly.data.map {
                mapWeatherHourlyData(it)
            },
            weatherAPIData.daily.summary,
            weatherAPIData.daily.icon,
            weatherAPIData.daily.data.map {
                mapWeatherDailyData(it)
            }
        )

    private fun mapWeatherDailyData(
        weatherInfoData: WeatherInfoDataDaily
    ): WeatherUIInfo = WeatherUIInfo(
        DateUtil.weatherInfoData(weatherInfoData.time),
        DateUtil.dayOfWeek(weatherInfoData.time),
        weatherInfoData.summary,
        weatherInfoData.icon,
        weatherInfoData.apparentTemperatureLow.roundToInt(),
        weatherInfoData.temperatureMin.roundToInt(),
        weatherInfoData.temperatureMax.roundToInt(),
        weatherInfoData.humidity.times(100).roundToInt()
    )

    private fun mapWeatherHourlyData(
        weatherInfoData: WeatherInfoData
    ): WeatherUIInfo = WeatherUIInfo(
        DateUtil.weatherInfoData(weatherInfoData.time),
        DateUtil.dayOfWeek(weatherInfoData.time),
        weatherInfoData.summary,
        weatherInfoData.icon,
        weatherInfoData.temperature.roundToInt(),
        humidityPercentage = weatherInfoData.humidity.times(100).roundToInt()
    )
}