package com.example.data.mappers

import com.example.data.model.FeelsLikeResponse
import com.example.domain.model.FeelsLike

class FeelsLikeMapper {
    fun toFeelsLike(response: FeelsLikeResponse?): FeelsLike =
        FeelsLike(
            day = response?.day ?: 0.0,
            eve = response?.eve  ?: 0.0,
            morn = response?.morn ?: 0.0,
            night = response?.night ?: 0.0
        )
}