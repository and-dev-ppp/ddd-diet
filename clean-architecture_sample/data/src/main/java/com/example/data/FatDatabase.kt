package com.example.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = arrayOf(FatEntity::class), version = 1)
abstract class FatDatabase : RoomDatabase() {
    abstract fun fatDao(): FatDao
}

object Database {
    @Volatile private var db: FatDatabase? = null

    @Synchronized
    fun getInstance(context: Context): FatDatabase {
        if (db == null) {
            db = Room.databaseBuilder(
                context,
                FatDatabase::class.java,
                "fat-db"
            ).build()
        }
        return db!!
    }
}