package com.example.klarnacodingchallenge.util

import android.Manifest
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.klarnacodingchallenge.util.Constants.LOCATION_PERMISSION_REQ_CODE
import com.example.klarnacodingchallenge.view.WeatherActivity
import kotlin.math.roundToInt


fun WeatherActivity.getLocationWithPermissionCheck() {
    if (ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED
    ) {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION),
            LOCATION_PERMISSION_REQ_CODE
        )
    } else {
        requestLocation()
    }
}

fun Double.convertFahrenheitToCelsius(): Int = ((roundToInt() - 32) * 5) / 9



