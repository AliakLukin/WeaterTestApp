package com.example.data.repository

import com.example.data.service.ApiService
import com.example.data.service.ApiServiceExecutor
import com.example.domain.ApiResult
import com.example.domain.model.CurrentForecast
import com.example.domain.model.Forecast

class NetworkDataSourceImpl (
    private val apiService: ApiService,
    private val apiServiceExecutor: ApiServiceExecutor
) : NetworkDataSource {
    override suspend fun getForecast(latitude: Double, longitude: Double): ApiResult<Forecast> =
        apiServiceExecutor.getForecast(apiService.getForecast(latitude, longitude))

    override suspend fun getCurrentWeather(
        latitude: Double,
        longitude: Double
    ): ApiResult<CurrentForecast> =
        apiServiceExecutor.getCurrentWeather(apiService.getCurrentWeather(latitude, longitude))

}