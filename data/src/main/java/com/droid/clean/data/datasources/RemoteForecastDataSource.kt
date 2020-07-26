package com.droid.clean.data.repository

import com.droid.clean.domain.models.Weather
import io.reactivex.Observable

interface RemoteForecastDataSource {
    fun getWeather(): Observable<Weather>
    fun getWeatherHistory(): Observable<List<Weather>>
}