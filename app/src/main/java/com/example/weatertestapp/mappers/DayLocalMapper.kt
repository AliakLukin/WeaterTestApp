package com.example.weatertestapp.mappers

import com.example.domain.model.Day
import com.example.weatertestapp.model.DayLocal

class DayLocalMapper(
    private val feelsLikeLocalMapper: FeelsLikeLocalMapper,
    private val tempLocalMapper: TempLocalMapper,
    private val weatherLocalMapper: WeatherLocalMapper
) {
    fun toDayLocal(day: Day): DayLocal =
        DayLocal(
            clouds = day.clouds,
            deg = day.deg,
            dt = day.dt,
            feelsLike = feelsLikeLocalMapper.toFeelsLikeLocal(day.feelsLike),
            gust = day.gust,
            humidity = day.humidity,
            pop = day.pop,
            pressure = day.pressure,
            rain = day.rain,
            speed = day.speed,
            sunrise = day.sunrise,
            sunset = day.sunset,
            temp = tempLocalMapper.toTempLocal(day.temp),
            weather = day.weather.map { weatherLocalMapper.toWeatherLocal(it) }
        )
}