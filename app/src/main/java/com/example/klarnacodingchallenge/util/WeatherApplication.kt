package com.example.klarnacodingchallenge.util

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Application class to provide initial point for initializing the HILT dependencies
 */
@HiltAndroidApp
class WeatherApplication : Application()