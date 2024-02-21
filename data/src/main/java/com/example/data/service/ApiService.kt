package com.example.data.service

import com.example.data.model.network.CurrentForecastResponse
import com.example.data.model.network.ForecastResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("forecast/daily")
    suspend fun getForecast(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("cnt") cnt: Int = 7,
        @Query("units") units: String = "metric"
    ): Response<ForecastResponse>

    @GET("weather")
    suspend fun getCurrentWeather(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("units") units: String = "metric"
    ): Response<CurrentForecastResponse>
}