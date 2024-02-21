package com.example.weatertestapp.mappers

import com.example.domain.model.local.Location
import com.example.weatertestapp.model.LocationLocal

class LocationLocalMapper {
    fun toLocationLocal(location: Location): LocationLocal =
        LocationLocal(
            id = location.id,
            name = location.name,
            latitude = location.latitude,
            longitude = location.longitude
        )

    fun toLocation(location: LocationLocal): Location =
        Location(
            id = location.id,
            name = location.name,
            latitude = location.latitude,
            longitude = location.longitude
        )
}