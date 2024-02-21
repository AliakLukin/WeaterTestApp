package com.example.domain.usecase.local

import com.example.domain.model.local.Location
import com.example.domain.repository.LocalRepository

class GetLocationsUseCase(private val localRepository: LocalRepository) {
    suspend fun get(): List<Location> = localRepository.getLocations()
}