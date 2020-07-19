package com.example.data.repositoryImpl

import com.example.data.store.FatLocalDataStore
import com.example.domain.repository.FatRepository

class FatRepositoryImpl(private val store: FatLocalDataStore) : FatRepository {
    override fun insert(weight: Float) {
        store.insert(76F)
    }
}