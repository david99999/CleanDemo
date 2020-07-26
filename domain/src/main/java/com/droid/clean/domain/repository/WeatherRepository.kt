package com.droid.clean.domain.repository

import com.droid.clean.domain.models.Weather
import io.reactivex.Observable

interface WeatherRepository {
    fun getWeather(): Observable<Weather>
    fun getWeatherHistory(): Observable<List<Weather>>
}