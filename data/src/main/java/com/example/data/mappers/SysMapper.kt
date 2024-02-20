package com.example.data.mappers

import com.example.data.model.SysResponse
import com.example.domain.model.Sys

class SysMapper {
    fun toSys(response: SysResponse?): Sys =
        Sys(
            country = response?.country ?: "",
            id = response?.id ?: 0,
            sunrise = response?.sunrise ?: 0,
            sunset = response?.sunset ?: 0,
            type = response?.type ?: 0
        )
}