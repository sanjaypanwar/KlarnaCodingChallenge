package com.example.klarnacodingchallenge.data.repository

import com.example.klarnacodingchallenge.data.datasource.WeatherRemoteDataSource
import com.example.klarnacodingchallenge.domain.DataHolder
import com.example.klarnacodingchallenge.domain.WeatherPresenterData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

/**
 * Weather repository class
 */
class WeatherRepository(
    private val dataSource: WeatherRemoteDataSource,
    private val weatherDataMapper: WeatherDataMapper,
    private val coroutineDispatcher: CoroutineDispatcher,
) : ApiResponseMapper(), IWeatherRepository {
    override fun getWeatherForGeoLocation(
        lat: Double,
        lng: Double
    ): Flow<DataHolder<WeatherPresenterData>> =
        safeApiCall { dataSource.getWeatherData(lat, lng) }.map {
            when (it) {
                is DataHolder.Success -> {
                    DataHolder.Success(weatherDataMapper.mapWeatherAPIData(it.data))
                }
                is DataHolder.Fail -> {
                    DataHolder.Fail(it.error, null)
                }
                is DataHolder.Loading -> {
                    DataHolder.Loading(null)
                }
            }
        }.flowOn(coroutineDispatcher)
}