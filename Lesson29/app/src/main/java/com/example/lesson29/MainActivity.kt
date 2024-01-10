package com.example.lesson29

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lesson29.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Измените импорт для использования полного пути к кнопке
        binding.btnOpenMap.setOnClickListener {
            startActivity(Intent(this, MapsActivity::class.java))
        }
    }
}