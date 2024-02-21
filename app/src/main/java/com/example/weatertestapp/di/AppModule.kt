package com.example.weatertestapp.di

import com.example.weatertestapp.mappers.DayLocalMapper
import com.example.weatertestapp.mappers.FeelsLikeLocalMapper
import com.example.weatertestapp.mappers.LocationLocalMapper
import com.example.weatertestapp.mappers.TempLocalMapper
import com.example.weatertestapp.mappers.WeatherLocalMapper
import com.example.weatertestapp.presentation.ui.home.HomeViewModel
import com.example.weatertestapp.presentation.ui.locationinfo.LocationInfoViewModel
import com.example.weatertestapp.presentation.ui.locations.LocationsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single { FeelsLikeLocalMapper() }
    single { TempLocalMapper() }
    single { WeatherLocalMapper() }
    single { DayLocalMapper(get(), get(), get()) }
    single { LocationLocalMapper() }

    viewModel {
        HomeViewModel(
            getForecastUseCase = get(),
            getCurrentWeatherUseCase = get(),
            dayLocalMapper = get()
        )
    }

    viewModel {
        LocationsViewModel(
            getLocationsUseCase = get(),
            insertLocationUseCase = get(),
            deleteLocationUseCase = get(),
            locationLocalMapper = get()
        )
    }

    viewModel {
        LocationInfoViewModel(
            getForecastUseCase = get(),
            dayLocalMapper = get()
        )
    }
}