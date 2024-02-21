package com.example.weatertestapp.di

import com.example.domain.usecase.local.DeleteLocationUseCase
import com.example.domain.usecase.local.GetLocationsUseCase
import com.example.domain.usecase.local.InsertLocationUseCase
import com.example.domain.usecase.network.GetCurrentWeatherUseCase
import com.example.domain.usecase.network.GetForecastUseCase
import org.koin.dsl.module

val domainModule = module {

    //Network
    single { GetForecastUseCase(get()) }
    single { GetCurrentWeatherUseCase(get()) }

    //Local
    single { GetLocationsUseCase(get()) }
    single { InsertLocationUseCase(get()) }
    single { DeleteLocationUseCase(get()) }
}