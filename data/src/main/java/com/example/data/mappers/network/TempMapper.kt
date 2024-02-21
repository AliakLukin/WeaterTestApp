package com.example.data.mappers.network

import com.example.data.model.network.TempResponse
import com.example.domain.model.network.Temp

class TempMapper {
    fun toTemp(response: TempResponse?): Temp =
        Temp(
            day = response?.day ?: 0.0,
            eve = response?.eve ?: 0.0,
            max = response?.max ?: 0.0,
            min = response?.min ?: 0.0,
            morn = response?.morn ?: 0.0,
            night = response?.night ?: 0.0
        )
}