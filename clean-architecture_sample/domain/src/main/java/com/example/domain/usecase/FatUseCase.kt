package com.example.domain.usecase

import com.example.domain.repository.FatRepository

class FatUseCase(private val repository: FatRepository) {
    fun insert(weight: Float) = repository.insert(weight)
}