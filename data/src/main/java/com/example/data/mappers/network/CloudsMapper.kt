package com.example.data.mappers.network

import com.example.data.model.network.CloudsResponse
import com.example.domain.model.network.Clouds

class CloudsMapper {
    fun toClouds(response: CloudsResponse?): Clouds =
        Clouds(all = response?.all ?: 0)
}