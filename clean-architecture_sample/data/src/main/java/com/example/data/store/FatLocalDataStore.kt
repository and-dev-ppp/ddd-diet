package com.example.data.store

import com.example.data.FatDatabase
import com.example.data.FatEntity
import java.util.*

class FatLocalDataStore(private val db: FatDatabase) {

    fun insert(weight: Float) {
        db.fatDao()
            .insertFatEntity(
                FatEntity(
                    id = 0,
                    weight = weight,
                    updateDate = Date().time,
                    createDate = Date().time
                )
            )
    }
}