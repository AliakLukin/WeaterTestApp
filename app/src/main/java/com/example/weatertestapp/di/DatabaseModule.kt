package com.example.weatertestapp.di

import android.app.Application
import androidx.room.Room
import com.example.data.database.AppDatabase
import com.example.data.database.LocationsDao
import org.koin.dsl.module

val databaseModule = module {
    fun provideDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "weatherDB")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideLocationDao(database: AppDatabase): LocationsDao {
        return database.locationsDao
    }

    single { provideDatabase(get()) }
    single { provideLocationDao(get()) }
}