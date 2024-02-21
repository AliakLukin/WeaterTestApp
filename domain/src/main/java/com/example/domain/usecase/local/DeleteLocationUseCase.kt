package com.example.domain.usecase.local

import com.example.domain.repository.LocalRepository

class DeleteLocationUseCase(private val localRepository: LocalRepository) {
    suspend fun delete(id: String) = localRepository.delete(id)
}