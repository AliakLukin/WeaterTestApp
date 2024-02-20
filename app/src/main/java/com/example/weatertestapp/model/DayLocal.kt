package com.example.weatertestapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DayLocal(
    val clouds: Int,
    val deg: Int,
    val dt: Int,
    val feelsLike: FeelsLikeLocal,
    val gust: Double,
    val humidity: Int,
    val pop: Double,
    val pressure: Int,
    val rain: Double,
    val speed: Double,
    val sunrise: Int,
    val sunset: Int,
    val temp: TempLocal,
    val weather: List<WeatherLocal>
): Parcelable
