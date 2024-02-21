package com.example.weatertestapp.mappers

import com.example.domain.model.network.Weather
import com.example.weatertestapp.model.WeatherLocal

class WeatherLocalMapper {
    fun toWeatherLocal(weather: Weather): WeatherLocal =
        WeatherLocal(
            description = weather.description,
            icon = weather.icon,
            id = weather.id,
            main = weather.main
        )
}