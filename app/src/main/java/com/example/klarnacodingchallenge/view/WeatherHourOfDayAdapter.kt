package com.example.klarnacodingchallenge.view

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.ImageViewCompat
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.example.klarnacodingchallenge.databinding.ItemWeatherHourOfDayBinding
import com.example.klarnacodingchallenge.domain.WeatherUIInfo
import com.example.klarnacodingchallenge.util.AppUtil
import com.example.klarnacodingchallenge.view.base.BaseAdapter

class WeatherHourOfDayAdapter :
    BaseAdapter<WeatherUIInfo>(
        diffCallback
    ) {

    override fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding {
        return ItemWeatherHourOfDayBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    }

    override fun bind(binding: ViewDataBinding, position: Int) {
        val weatherUIInfo = getItem(position)
        (binding as ItemWeatherHourOfDayBinding).textViewHourOfDay.text =
            weatherUIInfo.timeTextValue
        binding.textViewTemp.text = AppUtil.getTemperatureText(weatherUIInfo.temperature)
        binding.imageViewForecastIcon.setImageResource(AppUtil.getWeatherIcon(weatherUIInfo.icon))
        ImageViewCompat.setImageTintList(binding.imageViewForecastIcon, ColorStateList.valueOf(AppUtil.getHourColor(position)))
        binding.executePendingBindings()
    }
}

val diffCallback = object : DiffUtil.ItemCallback<WeatherUIInfo>() {
    override fun areContentsTheSame(oldItem: WeatherUIInfo, newItem: WeatherUIInfo): Boolean =
        oldItem == newItem

    override fun areItemsTheSame(oldItem: WeatherUIInfo, newItem: WeatherUIInfo): Boolean =
        oldItem.summary == newItem.summary
}
