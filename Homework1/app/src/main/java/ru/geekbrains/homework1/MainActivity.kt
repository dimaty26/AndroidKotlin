package ru.geekbrains.homework1

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button = findViewById<Button>(R.id.button1)
        button.setOnClickListener { Toast.makeText(this, "Clicked", Toast.LENGTH_LONG).show() }
    }
}