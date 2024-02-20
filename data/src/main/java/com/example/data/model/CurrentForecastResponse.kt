package com.example.data.model

data class CurrentForecastResponse(
    val base: String,
    val clouds: CloudsResponse,
    val cod: Int,
    val coord: CoordResponse,
    val dt: Int,
    val id: Int,
    val main: MainInfoResponse,
    val name: String,
    val sys: SysResponse,
    val timezone: Int,
    val visibility: Int,
    val weather: List<WeatherResponse>,
    val wind: WindResponse
)