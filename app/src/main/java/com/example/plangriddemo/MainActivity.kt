package com.example.plangriddemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.droid.clean.data.di.RepositoriesFactory
import com.droid.clean.domain.usecases.GetWeatherForecastUseCase
import com.droid.clean.presentation.WeatherContract
import com.droid.clean.presentation.WeatherForecastPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), WeatherContract.WeatherView {
    private lateinit var presenter: WeatherForecastPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = WeatherForecastPresenter(
            GetWeatherForecastUseCase(RepositoriesFactory.getWeatherRepository()),
            this
        )
        presenter.getWeather()
    }

    override fun showWeather(temperature: Int) {
        label.text = getString(R.string.temperature_label, temperature)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

}