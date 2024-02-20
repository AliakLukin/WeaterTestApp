package com.example.weatertestapp.di

import com.example.data.mappers.CityMapper
import com.example.data.mappers.CloudsMapper
import com.example.data.mappers.CoordMapper
import com.example.data.mappers.CurrentForecastMapper
import com.example.data.mappers.DayMapper
import com.example.data.mappers.FeelsLikeMapper
import com.example.data.mappers.ForecastMapper
import com.example.data.mappers.MainInfoMapper
import com.example.data.mappers.SysMapper
import com.example.data.mappers.TempMapper
import com.example.data.mappers.WeatherMapper
import com.example.data.mappers.WindMapper
import com.example.data.repository.NetworkDataSource
import com.example.data.repository.NetworkDataSourceImpl
import com.example.data.repository.NetworkRepositoryImpl
import com.example.data.service.ApiServiceExecutor
import com.example.domain.repository.NetworkRepository
import org.koin.dsl.module

val dataModule = module {

    single { CoordMapper() }
    single { CityMapper(get()) }
    single { FeelsLikeMapper() }
    single { TempMapper() }
    single { WeatherMapper() }
    single { WindMapper() }
    single { CloudsMapper() }
    single { MainInfoMapper() }
    single { SysMapper() }
    single {
        CurrentForecastMapper(
            cloudsMapper = get(),
            mainInfoMapper = get(),
            weatherMapper = get(),
            sysMapper = get(),
            coordMapper = get(),
            windMapper = get()
        )
    }
    single { DayMapper(feelsLikeMapper = get(), tempMapper = get(), weatherMapper = get()) }
    single { ForecastMapper(cityMapper = get(), dayMapper = get()) }

    factory {
        ApiServiceExecutor(
            forecastMapper = get(),
            currentForecastMapper = get()
        )
    }

    single<NetworkDataSource> {
        NetworkDataSourceImpl(apiService = get(), apiServiceExecutor = get())
    }

    single<NetworkRepository> {
        NetworkRepositoryImpl(dataSource = get())
    }
}