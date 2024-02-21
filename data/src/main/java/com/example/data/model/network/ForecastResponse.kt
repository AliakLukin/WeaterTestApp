package com.example.data.model.network

data class ForecastResponse(
    val city: CityResposne,
    val cnt: Int,
    val cod: String,
    val list: List<DayResponse>,
    val message: Double
)