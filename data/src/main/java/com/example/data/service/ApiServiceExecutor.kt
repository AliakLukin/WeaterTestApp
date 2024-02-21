package com.example.data.service

import com.example.data.mappers.network.CurrentForecastMapper
import com.example.data.mappers.network.ForecastMapper
import com.example.data.model.network.CurrentForecastResponse
import com.example.data.model.network.ForecastResponse
import com.example.domain.ApiResult
import com.example.domain.model.network.CurrentForecast
import com.example.domain.model.network.Forecast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class ApiServiceExecutor(
    private val forecastMapper: ForecastMapper,
    private val currentForecastMapper: CurrentForecastMapper
) {
    suspend fun getForecast(response: Response<ForecastResponse>): ApiResult<Forecast> =
        withContext(Dispatchers.IO) {
            try {
                if (response.isSuccessful) {
                    return@withContext ApiResult.Success(forecastMapper.toForecast(response.body()))
                } else {
                    return@withContext ApiResult.Error(Throwable(response.errorBody().toString()))
                }
            } catch (e: Exception) {
                return@withContext ApiResult.Error(e)
            }
        }

    suspend fun getCurrentWeather(response: Response<CurrentForecastResponse>): ApiResult<CurrentForecast> =
        withContext(Dispatchers.IO) {
            try {
                if (response.isSuccessful) {
                    return@withContext ApiResult.Success(currentForecastMapper.toCurrent(response.body()))
                } else {
                    return@withContext ApiResult.Error(Throwable(response.errorBody().toString()))
                }
            } catch (e: Exception) {
                return@withContext ApiResult.Error(e)
            }
        }
}