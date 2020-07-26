package com.droid.clean.data.datasources.impl

import com.droid.clean.data.repository.RemoteForecastDataSource
import com.droid.clean.domain.models.Weather
import io.reactivex.Observable
import kotlin.random.Random

class RemoteForecastDataSourceImpl : RemoteForecastDataSource {
    override fun getWeather(): Observable<Weather> {
        return Observable.just(Weather(temperature = Random.nextInt()))
    }

    override fun getWeatherHistory(): Observable<List<Weather>> {
        return Observable.just(listOf(
            Weather(temperature = Random.nextInt()),
            Weather(temperature = Random.nextInt())
        ))
    }

}