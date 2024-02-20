package com.example.data.mappers

import com.example.data.model.CurrentForecastResponse
import com.example.domain.model.CurrentForecast

class CurrentForecastMapper(
    private val cloudsMapper: CloudsMapper,
    private val coordMapper: CoordMapper,
    private val mainInfoMapper: MainInfoMapper,
    private val sysMapper: SysMapper,
    private val weatherMapper: WeatherMapper,
    private val windMapper: WindMapper
) {
    fun toCurrent(response: CurrentForecastResponse?): CurrentForecast =
        CurrentForecast(
            base = response?.base ?: "",
            clouds = cloudsMapper.toClouds(response?.clouds),
            cod = response?.cod ?: 0,
            coord = coordMapper.toCoord(response?.coord),
            dt = response?.dt ?: 0,
            id = response?.id ?: 0,
            main = mainInfoMapper.toMainInfo(response?.main),
            name = response?.name ?: "",
            sys = sysMapper.toSys(response?.sys),
            timezone = response?.timezone ?: 0,
            visibility = response?.visibility ?: 0,
            weather = response?.weather?.map { weatherMapper.toWeather(it) } ?: emptyList(),
            wind = windMapper.toWind(response?.wind)
        )

}