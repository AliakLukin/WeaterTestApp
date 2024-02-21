package com.example.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.model.local.LocationEntity

@Database(
    entities = [LocationEntity::class],
    version = 1,
    exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {
    abstract val locationsDao: LocationsDao
}