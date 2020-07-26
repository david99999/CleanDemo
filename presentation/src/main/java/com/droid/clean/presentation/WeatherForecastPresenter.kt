package com.droid.clean.presentation

import com.droid.clean.domain.usecases.GetWeatherForecastUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class WeatherForecastPresenter(
    private val weatherUseCase: GetWeatherForecastUseCase,
    private var view: WeatherContract.WeatherView?
) : WeatherContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun getWeather() {
        compositeDisposable.add(
            weatherUseCase.getWeatherInfo()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map {
                    it.temperature = Math.abs(it.temperature)
                    return@map it
                }
                .subscribe {
                    view?.showWeather(it.temperature)
                })
    }

    override fun onDestroy() {
        compositeDisposable.clear()
        view = null
    }

}

interface WeatherContract {
    interface WeatherView {
        fun showWeather(temperature: Int)
    }

    interface Presenter {
        fun getWeather()
        fun onDestroy()
    }
}