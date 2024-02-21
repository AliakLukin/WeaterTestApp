package com.example.domain.model.network

data class Forecast(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<Day>,
    val message: Double
)
