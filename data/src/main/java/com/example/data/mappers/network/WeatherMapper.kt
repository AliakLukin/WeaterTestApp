package com.example.data.mappers.network

import com.example.data.model.network.WeatherResponse
import com.example.domain.model.network.Weather

class WeatherMapper {
    fun toWeather(response: WeatherResponse?): Weather =
        Weather(
            description = response?.description ?: "",
            icon = response?.icon ?: "",
            id = response?.id ?: 0,
            main = response?.main ?: ""
        )
}