package com.example.data.mappers.network

import com.example.data.model.network.WindResponse
import com.example.domain.model.network.Wind

class WindMapper {
    fun toWind(response: WindResponse?): Wind =
        Wind(
            deg = response?.deg ?: 0,
            gust = response?.gust ?: 0.0,
            speed = response?.speed ?: 0.0
        )
}