package com.droid.clean.data.di

import com.droid.clean.domain.repository.WeatherRepository
import com.droid.clean.data.repository.WeatherRepositoryImpl

object RepositoriesFactory {
    fun getWeatherRepository(): WeatherRepository {
        return WeatherRepositoryImpl()
    }
}