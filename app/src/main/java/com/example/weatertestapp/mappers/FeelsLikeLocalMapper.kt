package com.example.weatertestapp.mappers

import com.example.domain.model.network.FeelsLike
import com.example.weatertestapp.model.FeelsLikeLocal

class FeelsLikeLocalMapper {
    fun toFeelsLikeLocal(feelsLike: FeelsLike): FeelsLikeLocal =
        FeelsLikeLocal(
            day = feelsLike.day,
            eve = feelsLike.eve,
            morn = feelsLike.morn,
            night = feelsLike.night
        )
}