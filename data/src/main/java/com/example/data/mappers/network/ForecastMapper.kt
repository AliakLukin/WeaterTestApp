package com.example.data.mappers.network

import com.example.data.model.network.ForecastResponse
import com.example.domain.model.network.Forecast

class ForecastMapper(
    private val cityMapper: CityMapper,
    private val dayMapper: DayMapper
) {
    fun toForecast(response: ForecastResponse?): Forecast =
        Forecast(
            city = cityMapper.toCity(response?.city),
            cnt = response?.cnt ?: 0,
            cod = response?.cod ?: "",
            list = response?.list?.map { dayMapper.toDay(it) } ?: emptyList(),
            message = response?.message ?: 0.0
        )
}