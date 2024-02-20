package com.example.data.repository

import com.example.domain.ApiResult
import com.example.domain.model.CurrentForecast
import com.example.domain.model.Forecast

interface NetworkDataSource {
    suspend fun getForecast(latitude: Double, longitude: Double): ApiResult<Forecast>
    suspend fun getCurrentWeather(latitude: Double, longitude: Double): ApiResult<CurrentForecast>
}