package ru.sofah.click

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private var counter: Int = 0
    private var counter2: Int = 0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.textView)
        val buttonCounter: Button = findViewById(R.id.button_count)
        val buttonCounter2: Button = findViewById(R.id.button_count2)



        val buttonHello: Button = findViewById(R.id.button_hello)
        buttonHello.setOnClickListener {
            textView.text = "Hello!"
        }

        buttonCounter2.setOnClickListener {
            textView.text = "Я насчитал ${++counter2} котов"
        }

        buttonCounter.setOnClickListener {
            textView.text = "Я насчитал ${++counter} ворон"
        }
    }
}