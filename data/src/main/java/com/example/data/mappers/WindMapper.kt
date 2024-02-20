package com.example.data.mappers

import com.example.data.model.WindResponse
import com.example.domain.model.Wind

class WindMapper {
    fun toWind(response: WindResponse?): Wind =
        Wind(
            deg = response?.deg ?: 0,
            gust = response?.gust ?: 0.0,
            speed = response?.speed ?: 0.0
        )
}