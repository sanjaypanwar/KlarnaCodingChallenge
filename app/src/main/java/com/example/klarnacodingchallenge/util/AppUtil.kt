package com.example.klarnacodingchallenge.util

import android.content.res.ColorStateList
import android.graphics.Color
import com.example.klarnacodingchallenge.R

object AppUtil {
    fun getWeatherIcon(icon: String): Int = when (icon) {
        "clear-day" -> R.drawable.clear_day
        "clear-night" -> R.drawable.clear_night
        "partly-cloudy-day" -> R.drawable.partly_cloudy_day
        "partly-cloudy-night" -> R.drawable.partly_cloudy_night
        "snow" -> R.drawable.snow
        "cloudy" -> R.drawable.cloudy
        "wind" -> R.drawable.wind
        "rain" -> R.drawable.rain
        "fog" -> R.drawable.fog
        else -> R.drawable.partly_cloudy_day
    }

    fun getTemperatureText(temperature: Int): String = "$temperature°"
    fun getBackGroundColor(dayOfWeek: String): ColorStateList {
        return ColorStateList.valueOf(
            when (dayOfWeek) {
                "Monday" -> Color.parseColor("#F44336")
                "Tuesday" -> Color.parseColor("#E91E63")
                "Wednesday" -> Color.parseColor("#AB47BC")
                "Thursday" -> Color.parseColor("#1DE9B6")
                "Friday" -> Color.parseColor("#F4511E")
                "Saturday" -> Color.parseColor("#0051FF")
                "Sunday" -> Color.parseColor("#3D28E0")
                else -> Color.parseColor("#28E0AE")
            }
        )
    }

    fun getHourColor(position: Int): Int {
        return when ((position + 1) % 9) {
            1 -> Color.parseColor("#28E0AE")
            2 -> Color.parseColor("#FF0090")
            3 -> Color.parseColor("#FFAE00")
            4 -> Color.parseColor("#0090FF")
            5 -> Color.parseColor("#DC0000")
            6 -> Color.parseColor("#0051FF")
            7 -> Color.parseColor("#3D28E0")
            8 -> Color.parseColor("#50E3FE")
            else -> Color.parseColor("#28E0AE")
        }
    }
}