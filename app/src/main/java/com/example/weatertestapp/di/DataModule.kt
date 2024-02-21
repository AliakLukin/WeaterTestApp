package com.example.weatertestapp.di

import com.example.data.mappers.local.LocationMapper
import com.example.data.mappers.network.CityMapper
import com.example.data.mappers.network.CloudsMapper
import com.example.data.mappers.network.CoordMapper
import com.example.data.mappers.network.CurrentForecastMapper
import com.example.data.mappers.network.DayMapper
import com.example.data.mappers.network.FeelsLikeMapper
import com.example.data.mappers.network.ForecastMapper
import com.example.data.mappers.network.MainInfoMapper
import com.example.data.mappers.network.SysMapper
import com.example.data.mappers.network.TempMapper
import com.example.data.mappers.network.WeatherMapper
import com.example.data.mappers.network.WindMapper
import com.example.data.repository.local.LocalDataSource
import com.example.data.repository.local.LocalDataSourceImpl
import com.example.data.repository.local.LocalRepositoryImpl
import com.example.data.repository.network.NetworkDataSource
import com.example.data.repository.network.NetworkDataSourceImpl
import com.example.data.repository.network.NetworkRepositoryImpl
import com.example.data.service.ApiServiceExecutor
import com.example.domain.repository.LocalRepository
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
    single { LocationMapper() }

    factory {
        ApiServiceExecutor(
            forecastMapper = get(),
            currentForecastMapper = get()
        )
    }

    single<LocalDataSource> {
        LocalDataSourceImpl(locationsDao = get(), locationMapper = get())
    }

    single<LocalRepository> {
        LocalRepositoryImpl(localDataSource = get(), locationMapper = get())
    }

    single<NetworkDataSource> {
        NetworkDataSourceImpl(apiService = get(), apiServiceExecutor = get())
    }

    single<NetworkRepository> {
        NetworkRepositoryImpl(dataSource = get())
    }
}