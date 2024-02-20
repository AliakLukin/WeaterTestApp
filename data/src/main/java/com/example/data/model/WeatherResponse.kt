package com.example.data.model

data class WeatherResponse(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)