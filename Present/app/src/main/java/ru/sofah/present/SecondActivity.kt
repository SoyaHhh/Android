package ru.sofah.present
import android.app.Activity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : Activity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val textview_second_info: TextView = findViewById(R.id.textView)

        val user = intent.extras?.getString("username")
        val  from = intent.extras?.getString("from")
        val  gift = intent.extras?.getString("gift")
        textview_second_info.text = "$user , вам передали $gift от  $from"
    }
}
