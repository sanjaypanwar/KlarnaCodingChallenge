package com.example.klarnacodingchallenge.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.example.klarnacodingchallenge.databinding.ItemDaysWeatherBinding
import com.example.klarnacodingchallenge.domain.WeatherUIInfo
import com.example.klarnacodingchallenge.util.AppUtil
import com.example.klarnacodingchallenge.view.base.BaseAdapter

class DailyWeatherAdapter : BaseAdapter<WeatherUIInfo>(diCallback) {

    override fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding {
        return ItemDaysWeatherBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    }

    override fun bind(binding: ViewDataBinding, position: Int) {
        val weatherUIInfo = getItem(position)
        (binding as ItemDaysWeatherBinding).imageViewWeatherIcon.setImageResource(
            AppUtil.getWeatherIcon(
                weatherUIInfo.icon
            )
        )
        binding.textViewTimeOfDay.text = weatherUIInfo.timeTextValue
        binding.textViewDayOfWeek.text = weatherUIInfo.dayOfWeek
        binding.textViewTemp.text = AppUtil.getTemperatureText(weatherUIInfo.temperature)
        binding.textViewMinTemp.text = AppUtil.getTemperatureText(weatherUIInfo.temperatureMin)
        binding.textViewMaxTemp.text = AppUtil.getTemperatureText(weatherUIInfo.temperatureMax)
        binding.cardView.backgroundTintList = AppUtil.getBackGroundColor(weatherUIInfo.dayOfWeek)
        binding.executePendingBindings()
    }
}

val diCallback = object : DiffUtil.ItemCallback<WeatherUIInfo>() {
    override fun areContentsTheSame(oldItem: WeatherUIInfo, newItem: WeatherUIInfo): Boolean =
        oldItem == newItem

    override fun areItemsTheSame(oldItem: WeatherUIInfo, newItem: WeatherUIInfo): Boolean =
        oldItem.summary == newItem.summary
}
