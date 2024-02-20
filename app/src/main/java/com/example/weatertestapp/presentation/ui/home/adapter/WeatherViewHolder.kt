package com.example.weatertestapp.presentation.ui.home.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.weatertestapp.R
import com.example.weatertestapp.databinding.ItemWeatherWithDateBinding
import com.example.weatertestapp.model.DayLocal
import com.example.weatertestapp.presentation.utils.convertTimestampToDay
import com.example.weatertestapp.presentation.utils.loadIcon
import com.example.weatertestapp.presentation.utils.setOnSafeClickListener

open class WeatherViewHolder(
    private val binding: ItemWeatherWithDateBinding,
    private val listener: OnWeatherItemClicked
) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(day: DayLocal) {
        val context = binding.root.context
        binding.run {
            iconIV.loadIcon(day.weather.firstOrNull()?.icon)
            temperatureTV.text = context.getString(R.string.temperature, day.temp.max.toString())
            descriptionTV.text = day.weather.firstOrNull()?.description
            dateTV.text = day.dt.convertTimestampToDay(context, false)
            nightTemperatureTV.text = context.getString(R.string.temperature, day.temp.night.toString())
            dayTemperatureTV.text = context.getString(R.string.temperature, day.temp.day.toString())
            root.setOnSafeClickListener {
                listener.onClicked(day)
            }
        }
    }
}