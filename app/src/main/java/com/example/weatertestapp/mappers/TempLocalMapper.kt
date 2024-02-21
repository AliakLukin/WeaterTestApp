package com.example.weatertestapp.mappers

import com.example.domain.model.network.Temp
import com.example.weatertestapp.model.TempLocal

class TempLocalMapper {
    fun toTempLocal(temp: Temp): TempLocal =
        TempLocal(
            day = temp.day,
            eve = temp.eve,
            max = temp.max,
            min = temp.min,
            morn = temp.morn,
            night = temp.night
        )
}