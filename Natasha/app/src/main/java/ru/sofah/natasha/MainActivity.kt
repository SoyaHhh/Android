package ru.sofah.natasha

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstText: TextView = findViewById(R.id.text1)
        val secondText: TextView = findViewById(R.id.text2)
        val thirdText: TextView = findViewById(R.id.text3)
        val forthText: TextView = findViewById(R.id.text4)
        val rightBottomImage: ImageView = findViewById(R.id.cat4)

        // Обработчик щелчков
        rightBottomImage.setOnClickListener {
            val phrases = listOf(
                "Уже 6 часов утра, Наташ",
                "Вставай, мы там всё уронили",
                "Мы уронили вообще всё, Наташ, честно",
                "Наташ, ты чё опять лежишь?",
                "Часики-то тикают",
                "Мужика-то хоть нашла себе?",
                "Уже дитачек пора рожать вообще-то")

            val shuffledList = phrases.shuffled() // перемешанный список

            // Выводим в текстовые метки
            firstText.text = shuffledList[0]
            secondText.text = shuffledList[1]
            thirdText.text = shuffledList[2]
            forthText.text = shuffledList[3]
        }
    }
}