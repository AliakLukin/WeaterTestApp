package com.example.domain.usecase.network

import com.example.domain.ApiResult
import com.example.domain.model.network.CurrentForecast
import com.example.domain.repository.NetworkRepository

class GetCurrentWeatherUseCase(private val networkRepository: NetworkRepository) {
    suspend fun get(latitude: Double, longitude: Double): ApiResult<CurrentForecast> =
        networkRepository.getCurrentWeather(latitude, longitude)
}