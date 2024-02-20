package com.example.weatertestapp.di

import com.example.weatertestapp.mappers.DayLocalMapper
import com.example.weatertestapp.mappers.FeelsLikeLocalMapper
import com.example.weatertestapp.mappers.TempLocalMapper
import com.example.weatertestapp.mappers.WeatherLocalMapper
import com.example.weatertestapp.presentation.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single { FeelsLikeLocalMapper() }
    single { TempLocalMapper() }
    single { WeatherLocalMapper() }
    single { DayLocalMapper(get(), get(), get()) }

    viewModel {
        HomeViewModel(getForecastUseCase = get(), getCurrentWeatherUseCase = get(), dayLocalMapper = get())
    }
}