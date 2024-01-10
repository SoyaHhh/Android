package com.example.lesson28

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        const val WHERE_MY_CAT_ACTION = "ru.alexanderklimov.action.CAT"
        const val ALARM_MESSAGE = "Срочно пришлите кота!"
    }

    private val receiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent?.action == WHERE_MY_CAT_ACTION) {
                val message = intent.getStringExtra("ru.alexanderklimov.broadcast.Message")
                showToast(message)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        registerReceiver(receiver, IntentFilter(WHERE_MY_CAT_ACTION))
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(receiver)
    }

    fun sendMessage(view: View) {
        val intent = Intent()
        intent.action = WHERE_MY_CAT_ACTION
        intent.putExtra("ru.alexanderklimov.broadcast.Message", ALARM_MESSAGE)
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES)
        sendBroadcast(intent)
    }

    private fun showToast(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}