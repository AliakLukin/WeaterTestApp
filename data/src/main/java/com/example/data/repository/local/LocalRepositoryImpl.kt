package com.example.data.repository.local

import com.example.data.mappers.local.LocationMapper
import com.example.domain.model.local.Location
import com.example.domain.repository.LocalRepository

class LocalRepositoryImpl(
    private val localDataSource: LocalDataSource,
    private val locationMapper: LocationMapper
): LocalRepository {
    override suspend fun getLocations(): List<Location> =
        localDataSource.getLocations()

    override suspend fun insertLocation(location: Location) =
        localDataSource.insertLocation(locationMapper.toLocationEntity(location))

    override suspend fun delete(id: String) =
        localDataSource.delete(id)
}