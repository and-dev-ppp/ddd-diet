package com.example.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "fat_table")
data class FatEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val weight: Float,
    @ColumnInfo(name = "update_date") val updateDate: Long,
    @ColumnInfo(name = "create_date") val createDate: Long
)