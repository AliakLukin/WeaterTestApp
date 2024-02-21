package com.example.weatertestapp.presentation.ui.locationinfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.network.GetForecastUseCase
import com.example.weatertestapp.mappers.DayLocalMapper
import com.example.weatertestapp.model.DayLocal
import com.example.weatertestapp.presentation.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class LocationInfoViewModel(
    private val getForecastUseCase: GetForecastUseCase,
    private val dayLocalMapper: DayLocalMapper
) : BaseViewModel() {

    private val _weeklyForecast = MutableLiveData<Pair<String, List<DayLocal>>?>()
    val weeklyForecast: LiveData<Pair<String, List<DayLocal>>?>
        get() = _weeklyForecast

    private val _isLoading = MutableLiveData(true)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    fun getWeeklyForecast(latitude: Double, longitude: Double) {
        viewModelScope.launch {
            _isLoading.postValue(true)
            val forecast = getDataByUseCase(
                getForecastUseCase.get(latitude, longitude)
            )
            forecast?.let {
                _weeklyForecast.postValue(
                    Pair(
                        forecast.city.name,
                        forecast.list.map { dayLocalMapper.toDayLocal(it) }
                    )
                )
            }
            _isLoading.postValue(false)
        }
    }

}