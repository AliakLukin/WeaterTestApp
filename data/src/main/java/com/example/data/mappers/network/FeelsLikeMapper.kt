package com.example.data.mappers.network

import com.example.data.model.network.FeelsLikeResponse
import com.example.domain.model.network.FeelsLike

class FeelsLikeMapper {
    fun toFeelsLike(response: FeelsLikeResponse?): FeelsLike =
        FeelsLike(
            day = response?.day ?: 0.0,
            eve = response?.eve  ?: 0.0,
            morn = response?.morn ?: 0.0,
            night = response?.night ?: 0.0
        )
}