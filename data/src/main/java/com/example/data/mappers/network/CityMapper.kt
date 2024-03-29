package com.example.data.mappers.network

import com.example.data.model.network.CityResposne
import com.example.domain.model.network.City

class CityMapper(private val coordMapper: CoordMapper) {
    fun toCity(response: CityResposne?): City =
        City(
            coord = coordMapper.toCoord(response?.coord),
            country = response?.country ?: "",
            id = response?.id ?: 0,
            name = response?.name ?: "",
            population = response?.population ?: 0,
            timezone = response?.timezone ?: 0
        )
}