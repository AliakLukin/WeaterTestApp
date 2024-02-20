package com.example.data.mappers

import com.example.data.model.DayResponse
import com.example.domain.model.Day

class DayMapper(
    private val feelsLikeMapper: FeelsLikeMapper,
    private val tempMapper: TempMapper,
    private val weatherMapper: WeatherMapper
) {
    fun toDay(response: DayResponse?): Day =
        Day(
            clouds = response?.clouds ?: 0,
            deg = response?.deg ?: 0,
            dt = response?.dt ?: 0,
            feelsLike = feelsLikeMapper.toFeelsLike(response?.feelsLike),
            gust = response?.gust ?: 0.0,
            humidity = response?.humidity ?: 0,
            pop = response?.pop ?: 0.0,
            pressure = response?.pressure ?: 0,
            rain = response?.rain ?: 0.0,
            speed = response?.speed ?: 0.0,
            sunrise = response?.sunrise ?: 0,
            sunset = response?.sunset ?: 0,
            temp = tempMapper.toTemp(response?.temp),
            weather = response?.weather?.map { weatherMapper.toWeather(it) } ?: emptyList()
        )
}