package com.example.data.mappers

import com.example.data.model.MainInfoResponse
import com.example.domain.model.MainInfo

class MainInfoMapper {
    fun toMainInfo(response: MainInfoResponse?): MainInfo =
        MainInfo(
            feelsLike = response?.feelsLike ?: 0.0,
            grndLevel = response?.grndLevel ?: 0,
            humidity = response?.humidity ?: 0,
            pressure = response?.pressure ?: 0,
            seaLevel = response?.seaLevel ?: 0,
            temp = response?.temp ?: 0.0,
            tempMax = response?.tempMax ?: 0.0,
            tempMin = response?.tempMin ?: 0.0
        )
}