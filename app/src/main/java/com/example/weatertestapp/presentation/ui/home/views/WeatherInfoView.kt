package com.example.weatertestapp.presentation.ui.home.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.domain.model.network.CurrentForecast
import com.example.weatertestapp.R
import com.example.weatertestapp.databinding.ItemWeatherInfoViewBinding
import com.example.weatertestapp.presentation.utils.loadIcon

class WeatherInfoView : LinearLayout {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private val binding: ItemWeatherInfoViewBinding = ItemWeatherInfoViewBinding.inflate(
        LayoutInflater.from(context), this, true
    )

    fun setUpView(currentForecast: CurrentForecast) {
        binding.run {
            cityTV.text = currentForecast.name
            tempNowTV.text = context.getString(
                R.string.temperature, currentForecast.main.temp.toString()
            )
            iconIV.loadIcon(currentForecast.weather.firstOrNull()?.icon)
            mainDescriptionTV.text = currentForecast.weather.firstOrNull()?.main
            secondaryDescriptionTV.text = currentForecast.weather.firstOrNull()?.description
        }
    }
}