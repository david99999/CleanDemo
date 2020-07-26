package com.droid.clean.data.datasources.impl

import com.droid.clean.data.repository.LocalForecastDataSource
import com.droid.clean.domain.models.Weather
import io.reactivex.Observable

class LocalForecastDataSourceImpl :
    LocalForecastDataSource {
    override fun getWeather(): Observable<Weather> {
        val oneToFive = 1..5
        return Observable.fromIterable(oneToFive)
            .map {
                Thread.sleep(2000)
                Weather(temperature = (5..30).random())
            }
    }
}