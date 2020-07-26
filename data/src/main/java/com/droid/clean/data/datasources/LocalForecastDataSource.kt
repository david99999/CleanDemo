package com.droid.clean.data.repository

import com.droid.clean.domain.models.Weather
import io.reactivex.Observable

interface LocalForecastDataSource {
    fun getWeather(): Observable<Weather>
}