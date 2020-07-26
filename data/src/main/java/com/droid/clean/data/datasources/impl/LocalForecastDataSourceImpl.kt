package com.droid.clean.data.datasources.impl

import com.droid.clean.data.repository.LocalForecastDataSource
import com.droid.clean.domain.models.Weather
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import java.util.concurrent.TimeUnit
import kotlin.random.Random

class LocalForecastDataSourceImpl :
    LocalForecastDataSource {
    override fun getWeather(): Observable<Weather> {
        val oneToFive = 1..5
        return Observable.zip(
            Observable.fromIterable(oneToFive),
            Observable.interval(2, TimeUnit.SECONDS),
            BiFunction<Int, Long, Long> { a, b -> return@BiFunction a.toLong() }
        )
            .doOnNext { println("emitido " + it) }
            .map { it + 100 }
            .flatMap {
                println("segungo flatmap" + it)
                return@flatMap Observable.just(Weather(temperature = (5..30).random()))
            }
    }
}