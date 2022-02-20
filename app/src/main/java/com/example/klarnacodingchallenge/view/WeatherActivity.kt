package com.example.klarnacodingchallenge.view

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.klarnacodingchallenge.R
import com.example.klarnacodingchallenge.databinding.ActivityWeatherBinding
import com.example.klarnacodingchallenge.domain.DataHolder
import com.example.klarnacodingchallenge.domain.WeatherUIInfo
import com.example.klarnacodingchallenge.util.AppUtil
import com.example.klarnacodingchallenge.util.Constants.LOCATION_PERMISSION_REQ_CODE
import com.example.klarnacodingchallenge.util.getLocationWithPermissionCheck
import com.example.klarnacodingchallenge.viewmodel.WeatherViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherActivity : AppCompatActivity() {
    private val weatherViewModel: WeatherViewModel by viewModels()
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private val mBinding: ActivityWeatherBinding by lazy {
        DataBindingUtil.inflate(
            LayoutInflater.from(this),
            R.layout.activity_weather,
            null,
            false
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
        mBinding.lifecycleOwner = this
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        getLocationWithPermissionCheck()
        setUI()
    }

    private fun fetchCurrentWeather(latitude: Double, longitude: Double) {
        weatherViewModel.loadWeatherData(latitude, longitude).observe(this) {
            when (it) {
                is DataHolder.Success -> {
                    stopProgress()
                    mBinding.rootView.visibility = View.VISIBLE
                    updateHeroUI(it.data.currentWeather)
                    (mBinding.recyclerDaysWeather.adapter as DailyWeatherAdapter).submitList(it.data.dailyWeatherDataList)
                    (mBinding.containerCurrent.recyclerViewHourOfDay.adapter as WeatherHourOfDayAdapter).submitList(it.data.hourlyWeatherDataList)
                    mBinding.txtVwNextDays.text =
                        getString(R.string.next_n_days, it.data.dailyWeatherDataList.size)
                }
                is DataHolder.Fail -> {
                    stopProgress()
                }
                is DataHolder.Loading -> {
                    showProgress()
                }
            }
        }
    }

    private fun updateHeroUI(currentWeather: WeatherUIInfo) {
        mBinding.containerCurrent.imageViewWeatherIcon.setImageResource(
            AppUtil.getWeatherIcon(
                currentWeather.icon
            )
        )
        mBinding.containerCurrent.textViewTemperature.text =
            AppUtil.getTemperatureText(currentWeather.temperature)
        mBinding.containerCurrent.textViewWeatherMain.text =
            currentWeather.summary
        mBinding.containerCurrent.textViewHumidity.text =
            AppUtil.getTemperatureText(currentWeather.humidityPercentage)
    }

    private fun setUI() {
        val adapter = DailyWeatherAdapter()
        mBinding.recyclerDaysWeather.adapter = adapter
        mBinding.recyclerDaysWeather.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        mBinding.recyclerDaysWeather.viewTreeObserver
            .addOnPreDrawListener {
                startPostponedEnterTransition()
                true
            }

        val weatherDayAdapter = WeatherHourOfDayAdapter()
        mBinding.containerCurrent.recyclerViewHourOfDay.adapter = weatherDayAdapter

    }

    /**
     * Show circular progress added in layout
     */
    private fun showProgress() {
        mBinding.progressBar.visibility = View.VISIBLE
    }

    /**
     * Hide the circular progress view
     */
    private fun stopProgress() {
        mBinding.progressBar.visibility = View.GONE
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>, grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            LOCATION_PERMISSION_REQ_CODE -> {
                // If request is cancelled, the result arrays are empty.
                if ((grantResults.isNotEmpty() &&
                            grantResults[0] == PackageManager.PERMISSION_GRANTED)
                ) {
                    requestLocation()
                } else {
                    Snackbar.make(
                        this,
                        mBinding.rootView,
                        "Location permission is required to run app.",
                        Snackbar.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    @SuppressLint("MissingPermission")
    fun requestLocation() {
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location: Location? ->
                location?.let {
                    fetchCurrentWeather(location.latitude, location.longitude)
                }
            }
    }
}