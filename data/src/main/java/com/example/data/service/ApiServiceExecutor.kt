package com.example.data.service

import com.example.data.mappers.CurrentForecastMapper
import com.example.data.mappers.ForecastMapper
import com.example.data.model.CurrentForecastResponse
import com.example.data.model.ForecastResponse
import com.example.domain.ApiResult
import com.example.domain.model.CurrentForecast
import com.example.domain.model.Forecast
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