package com.example.data.repository

import com.example.domain.ApiResult
import com.example.domain.model.CurrentForecast
import com.example.domain.model.Forecast
import com.example.domain.repository.NetworkRepository

class NetworkRepositoryImpl(
    private val dataSource: NetworkDataSource,
) : NetworkRepository {
    override suspend fun getForecast(latitude: Double, longitude: Double): ApiResult<Forecast> =
        dataSource.getForecast(latitude, longitude)

    override suspend fun getCurrentWeather(
        latitude: Double,
        longitude: Double
    ): ApiResult<CurrentForecast> =
        dataSource.getCurrentWeather(latitude, longitude)

}