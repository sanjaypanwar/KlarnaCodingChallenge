package com.example.klarnacodingchallenge.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.klarnacodingchallenge.domain.DataHolder
import com.example.klarnacodingchallenge.domain.WeatherPresenterData
import com.example.klarnacodingchallenge.usercases.Interactors
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

/**
 * View model class for providing view data for weather list.
 */
@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val interators: Interactors,
    private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    /**
     * Coroutine live data for getting WeatherUI data from repository.
     */
    fun loadWeatherData(lat: Double, lng: Double): LiveData<DataHolder<WeatherPresenterData>> =
        liveData(dispatcher) {
            interators.getWeatherData(lat, lng)
                .onStart {
                    emit(DataHolder.Loading(null))
                }.catch { exception ->
                    val errorMessage = exception.message ?: exception.toString()
                    DataHolder.Fail("Api call failed $errorMessage", null)
                }.collect {
                    emit(it)
                }
        }

}