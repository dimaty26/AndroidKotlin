package ru.geekbrains.homework3.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.geekbrains.homework3.R
import ru.geekbrains.homework3.databinding.ActivityMainBinding
import ru.geekbrains.homework3.fragments.MainFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance()).commit()
        }
    }
}