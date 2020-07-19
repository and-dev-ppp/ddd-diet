package com.example.data

import androidx.room.*

@Dao
interface FatDao {
    @Query("SELECT * FROM fat_table")
    fun getAll(): List<FatEntity>

    @Query("SELECT weight FROM fat_table")
    fun getWeights(): List<Float>

    @Insert
    fun insertFatEntity(vararg fatEntity: FatEntity)

    @Delete
    fun delete(fatEntity: FatEntity)

    @Update
    fun update(fatEntity: FatEntity)
}