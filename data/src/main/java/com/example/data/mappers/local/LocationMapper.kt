package com.example.data.mappers.local

import com.example.data.model.local.LocationEntity
import com.example.domain.model.local.Location

class LocationMapper {
    fun toLocation(location: LocationEntity): Location =
        Location(
            id = location.id,
            name = location.name,
            latitude = location.latitude,
            longitude = location.longitude
        )

    fun toLocationEntity(location: Location): LocationEntity =
        LocationEntity(
            id = location.id,
            name = location.name,
            latitude = location.latitude,
            longitude = location.longitude
        )
}