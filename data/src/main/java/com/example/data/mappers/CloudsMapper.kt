package com.example.data.mappers

import com.example.data.model.CloudsResponse
import com.example.domain.model.Clouds

class CloudsMapper {
    fun toClouds(response: CloudsResponse?): Clouds =
        Clouds(all = response?.all ?: 0)
}