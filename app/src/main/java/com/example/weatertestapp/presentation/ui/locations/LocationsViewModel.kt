package com.example.weatertestapp.presentation.ui.locations

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.local.DeleteLocationUseCase
import com.example.domain.usecase.local.GetLocationsUseCase
import com.example.domain.usecase.local.InsertLocationUseCase
import com.example.weatertestapp.mappers.LocationLocalMapper
import com.example.weatertestapp.model.LocationLocal
import com.example.weatertestapp.presentation.ui.base.BaseViewModel
import com.example.weatertestapp.presentation.utils.SingleLiveEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.UUID

class LocationsViewModel(
    private val getLocationsUseCase: GetLocationsUseCase,
    private val insertLocationUseCase: InsertLocationUseCase,
    private val deleteLocationUseCase: DeleteLocationUseCase,
    private val locationLocalMapper: LocationLocalMapper
) : BaseViewModel() {

    private val _locations = MutableLiveData<List<LocationLocal>>()
    val locations: LiveData<List<LocationLocal>>
        get() = _locations

    private val _errorOnSave = SingleLiveEvent<Boolean>()
    val errorOnSave: LiveData<Boolean>
        get() = _errorOnSave

    fun getLocations() {
        viewModelScope.launch(Dispatchers.IO) {
            _locations.postValue(
                getLocationsUseCase.get().map { locationLocalMapper.toLocationLocal(it) }
            )
        }
    }

    fun saveLocation(name: String?, latitude: Double?, longitude: Double?) {
        viewModelScope.launch(Dispatchers.IO) {
            if (name.isNullOrEmpty() || latitude == null || longitude == null) {
                _errorOnSave.postValue(true)
                return@launch
            }
            _errorOnSave.postValue(false)
            insertLocationUseCase.insert(
                locationLocalMapper.toLocation(
                    LocationLocal(
                        UUID.randomUUID().toString(),
                        name,
                        latitude,
                        longitude
                    )
                )
            )
            getLocations()
        }
    }

    fun delete(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteLocationUseCase.delete(id)
            getLocations()
        }
    }
}