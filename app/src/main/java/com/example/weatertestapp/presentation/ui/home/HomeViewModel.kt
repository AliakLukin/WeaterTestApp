package com.example.weatertestapp.presentation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.model.CurrentForecast
import com.example.domain.model.Forecast
import com.example.domain.usecase.GetCurrentWeatherUseCase
import com.example.domain.usecase.GetForecastUseCase
import com.example.weatertestapp.mappers.DayLocalMapper
import com.example.weatertestapp.model.DayLocal
import com.example.weatertestapp.model.LatLongLocal
import com.example.weatertestapp.presentation.ui.base.BaseViewModel
import com.example.weatertestapp.presentation.utils.SingleLiveEvent
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getForecastUseCase: GetForecastUseCase,
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase,
    private val dayLocalMapper: DayLocalMapper
) : BaseViewModel() {

    private val _currentForecast = MutableLiveData<CurrentForecast?>()
    val currentForecast: LiveData<CurrentForecast?>
        get() = _currentForecast

    private val _weeklyForecast = MutableLiveData<List<DayLocal>?>()
    val weeklyForecast: LiveData<List<DayLocal>?>
        get() = _weeklyForecast

    private val _latLongLocal = SingleLiveEvent<LatLongLocal>()
    val latLongLocal: LiveData<LatLongLocal>
        get() = _latLongLocal

    private val _isLoading = MutableLiveData<Boolean>(true)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    fun getCurrentWeather(latitude: Double, longitude: Double) {
        viewModelScope.launch {
            _isLoading.postValue(true)
            _currentForecast.postValue(
                getDataByUseCase(
                    getCurrentWeatherUseCase.get(latitude, longitude)
                )
            )
            _weeklyForecast.postValue(
                getDataByUseCase(
                    getForecastUseCase.get(latitude, longitude)
                )?.list?.map { dayLocalMapper.toDayLocal(it) }
            )
            _isLoading.postValue(false)
        }
    }

    fun setCurrentLocation(latLatLongLocal: LatLongLocal) {
        _latLongLocal.value = latLatLongLocal
    }
}