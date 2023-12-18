package ru.sofah.hellokitty

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var helloTextView: TextView
    private lateinit var editText: EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        helloTextView = findViewById(R.id.textView)
        editText = findViewById(R.id.editText)

        val imageButton: ImageButton = findViewById(R.id.imageButton)

        imageButton.setOnClickListener {
            if (editText.text.isEmpty()) {
                helloTextView.text = "Hello Kitty!"
            } else {
                helloTextView.text = "Привет, " + editText.text
            }
        }
    }
}
