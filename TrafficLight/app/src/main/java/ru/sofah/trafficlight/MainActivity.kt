package ru.sofah.trafficlight

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private lateinit var rootLayout: ConstraintLayout
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rootLayout = findViewById(R.id.layout_root)
        textView = findViewById(R.id.textView)

        val redButton: Button = findViewById(R.id.button_red)
        val yellowButton: Button = findViewById(R.id.button_yellow)
        val greenButton: Button = findViewById(R.id.button_green)

        redButton.setOnClickListener { onButtonClick("Красный", R.color.redColor) }
        yellowButton.setOnClickListener { onButtonClick(getString(R.string.yellow), R.color.yellowColor) }
        greenButton.setOnClickListener { onButtonClick(getString(R.string.green), Color.GREEN) }
    }
    private fun onButtonClick(text: String, colorResId: Int) {
        textView.text = text
        rootLayout.setBackgroundColor(when {
            colorResId != Color.GREEN -> ContextCompat.getColor(this, colorResId)
            else -> colorResId
        })
    }
}