package com.example.weatertestapp.di

import com.example.domain.usecase.GetCurrentWeatherUseCase
import com.example.domain.usecase.GetForecastUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetForecastUseCase(get()) }
    single { GetCurrentWeatherUseCase(get()) }
}