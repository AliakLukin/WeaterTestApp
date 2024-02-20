package com.example.domain.usecase

import com.example.domain.ApiResult
import com.example.domain.model.Forecast
import com.example.domain.repository.NetworkRepository

class GetForecastUseCase(private val networkRepository: NetworkRepository) {
    suspend fun get(latitude: Double, longitude: Double): ApiResult<Forecast> =
        networkRepository.getForecast(latitude, longitude)
}