package com.example.klarnacodingchallenge.util

import java.text.SimpleDateFormat
import java.util.*

object DateUtil {
    fun weatherInfoData(timeStamp: Long): String = SimpleDateFormat("HH:mm", Locale.getDefault())
        .format(Date(timeStamp * 1000))

    fun dayOfWeek(timeStamp: Long): String = SimpleDateFormat("EEEE", Locale.getDefault())
        .format(Date(timeStamp * 1000))

}