package com.example.data.repository.local

import com.example.data.database.LocationsDao
import com.example.data.mappers.local.LocationMapper
import com.example.data.model.local.LocationEntity
import com.example.domain.model.local.Location

class LocalDataSourceImpl(
    private val locationsDao: LocationsDao,
    private val locationMapper: LocationMapper
): LocalDataSource {
    override suspend fun getLocations(): List<Location> =
        locationsDao.getLocations().map { locationMapper.toLocation(it) }

    override suspend fun insertLocation(location: LocationEntity) =
        locationsDao.insert(location)

    override suspend fun delete(id: String) =
        locationsDao.delete(id)
}