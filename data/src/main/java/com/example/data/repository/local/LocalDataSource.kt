package com.example.data.repository.local

import com.example.data.model.local.LocationEntity
import com.example.domain.model.local.Location

interface LocalDataSource {
    suspend fun getLocations(): List<Location>
    suspend fun insertLocation(location: LocationEntity)
    suspend fun delete(id: String)
}