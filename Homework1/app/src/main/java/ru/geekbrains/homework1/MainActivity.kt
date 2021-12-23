package ru.geekbrains.homework1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var weather = Weather("Moscow", -16)


        var button = findViewById<Button>(R.id.button1)
        var textCity = findViewById<TextView>(R.id.weather_city)
        var textTemp = findViewById<TextView>(R.id.weather_temp);
        button.setOnClickListener {
            textCity.text = weather.city
            textTemp.text = weather.temper.toString()
        }
    }
}