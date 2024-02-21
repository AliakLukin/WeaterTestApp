package com.example.domain.usecase.local

import com.example.domain.model.local.Location
import com.example.domain.repository.LocalRepository

class InsertLocationUseCase(private val localRepository: LocalRepository) {
    suspend fun insert(location: Location) = localRepository.insertLocation(location)
}