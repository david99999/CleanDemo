package com.droid.clean.domain.usecases

import com.droid.clean.domain.models.Weather
import com.droid.clean.domain.repository.WeatherRepository
import io.reactivex.Observable

class GetWeatherForecastUseCase(private val repository: WeatherRepository) {
    fun getWeatherInfo(): Observable<Weather> {
        return repository.getWeather()
    }
}