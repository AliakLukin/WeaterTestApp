package com.example.data.mappers.network

import com.example.data.model.network.CoordResponse
import com.example.domain.model.network.Coord

class CoordMapper {
    fun toCoord(response: CoordResponse?): Coord =
        Coord(
            latitude = response?.latitude ?: 0.0,
            longitude = response?.longitude ?: 0.0
        )
}