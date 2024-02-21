package com.example.domain.repository

import com.example.domain.model.local.Location

interface LocalRepository {
    suspend fun getLocations(): List<Location>
    suspend fun insertLocation(location: Location)
    suspend fun delete(id: String)
}