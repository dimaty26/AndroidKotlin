package ru.geekbrains.homework1

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var weather = Weather("Moscow", -16)

        var teslaCar = Car.getModel();


        var button = findViewById<Button>(R.id.button1)
        var textCity = findViewById<TextView>(R.id.weather_city)
        var textTemp = findViewById<TextView>(R.id.weather_temp)
        var modelCar = findViewById<TextView>(R.id.model_car)
        button.setOnClickListener {
            textCity.text = weather.city
            modelCar.text = teslaCar
            textTemp.text = weather.temper.toString()
        }

        for (i in 1..10) {
            Log.d("For Loop", i.toString())
        }

        for (i in 10 downTo 1 step 2) {
            Log.d("Down For Loop", i.toString())
        }
    }
}