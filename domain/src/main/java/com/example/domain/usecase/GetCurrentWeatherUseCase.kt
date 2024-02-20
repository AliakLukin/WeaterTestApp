package com.example.domain.usecase

import com.example.domain.ApiResult
import com.example.domain.model.CurrentForecast
import com.example.domain.repository.NetworkRepository

class GetCurrentWeatherUseCase(private val networkRepository: NetworkRepository) {
    suspend fun get(latitude: Double, longitude: Double): ApiResult<CurrentForecast> =
        networkRepository.getCurrentWeather(latitude, longitude)
}