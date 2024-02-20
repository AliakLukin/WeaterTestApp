package com.example.data.mappers

import com.example.data.model.CoordResponse
import com.example.domain.model.Coord

class CoordMapper {
    fun toCoord(response: CoordResponse?): Coord =
        Coord(
            latitude = response?.latitude ?: 0.0,
            longitude = response?.longitude ?: 0.0
        )
}