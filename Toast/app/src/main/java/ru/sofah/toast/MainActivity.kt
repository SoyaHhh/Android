package ru.sofah.toast

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            val toast = Toast.makeText(applicationContext, R.string.cat_food, Toast.LENGTH_LONG)
            val constraintLayout = ConstraintLayout(this)
            val catImage = ImageView(this)
            catImage.setImageResource(R.drawable.hungrycat)

            constraintLayout.addView(catImage)

            toast.view = constraintLayout

            toast.show()
        }
    }
}