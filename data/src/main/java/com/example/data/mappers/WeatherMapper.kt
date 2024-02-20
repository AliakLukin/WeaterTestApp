package com.example.data.mappers

import com.example.data.model.WeatherResponse
import com.example.domain.model.Weather

class WeatherMapper {
    fun toWeather(response: WeatherResponse?): Weather =
        Weather(
            description = response?.description ?: "",
            icon = response?.icon ?: "",
            id = response?.id ?: 0,
            main = response?.main ?: ""
        )
}