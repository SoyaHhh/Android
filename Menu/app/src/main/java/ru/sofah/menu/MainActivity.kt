package ru.sofah.menu
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {


    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }
//у Климова ниче не работает 
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_cat1 -> {
                //textView.text = "Вы выбрали кота!"
                return true
            }
            R.id.action_cat2 -> {
                //textView.text = "Вы выбрали кошку!"
                return true
            }
            R.id.action_cat3 -> {
                //textView.text = "Вы выбрали котёнка!"
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}