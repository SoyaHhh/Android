package ru.sofah.present

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var editText3: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.button)

        editText1 = findViewById(R.id.edit_gift)
        editText2 = findViewById(R.id.edit_address)
        editText3 = findViewById(R.id.edit_name)

        button.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            // в ключ username пихаем текст из первого текстового поля
            intent.putExtra("gift", editText1.text.toString())
            intent.putExtra("from", editText2.text.toString())
            intent.putExtra("username", editText3.text.toString())


            startActivity(intent)
        }


    }
}
