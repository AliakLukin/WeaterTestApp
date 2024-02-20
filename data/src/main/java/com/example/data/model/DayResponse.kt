package com.example.data.model

import com.google.gson.annotations.SerializedName

data class DayResponse(
    val clouds: Int,
    val deg: Int,
    val dt: Int,
    @SerializedName("feels_like")
    val feelsLike: FeelsLikeResponse,
    val gust: Double,
    val humidity: Int,
    val pop: Double,
    val pressure: Int,
    val rain: Double,
    val speed: Double,
    val sunrise: Int,
    val sunset: Int,
    val temp: TempResponse,
    val weather: List<WeatherResponse>
)