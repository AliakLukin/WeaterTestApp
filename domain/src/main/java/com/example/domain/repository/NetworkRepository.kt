package com.example.domain.repository

import com.example.domain.ApiResult
import com.example.domain.model.CurrentForecast
import com.example.domain.model.Forecast

interface NetworkRepository {
    suspend fun getForecast(latitude: Double, longitude: Double): ApiResult<Forecast>
    suspend fun getCurrentWeather(latitude: Double, longitude: Double): ApiResult<CurrentForecast>
}