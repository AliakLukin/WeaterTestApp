package com.example.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.model.local.LocationEntity

@Dao
interface LocationsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(locationEntity: LocationEntity)

    @Query("SELECT * FROM locations")
    fun getLocations(): List<LocationEntity>

    @Query("DELETE FROM locations WHERE id = :id")
    fun delete(id: String)
}