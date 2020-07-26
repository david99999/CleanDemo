package com.droid.clean.data.repository

import com.droid.clean.data.datasources.impl.LocalForecastDataSourceImpl
import com.droid.clean.data.datasources.impl.RemoteForecastDataSourceImpl
import com.droid.clean.domain.models.Weather
import com.droid.clean.domain.repository.WeatherRepository
import io.reactivex.Observable

class WeatherRepositoryImpl : WeatherRepository {

    private val localDataSource: LocalForecastDataSource =
        LocalForecastDataSourceImpl()
    private val remoteDataSource: RemoteForecastDataSource =
        RemoteForecastDataSourceImpl()

    override fun getWeather(): Observable<Weather> {
        return localDataSource.getWeather() //TODO: Pendiente definir fuente
    }

    override fun getWeatherHistory():  Observable<List<Weather>> {
        return remoteDataSource.getWeatherHistory()
    }
}