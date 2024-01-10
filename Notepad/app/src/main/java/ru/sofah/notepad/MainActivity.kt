package ru.sofah.notepad

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import java.io.File

class MainActivity : AppCompatActivity() {

    private val FILENAME = "sample.txt" // имя файла
    private lateinit var editText: EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        editText = findViewById(R.id.editText)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_open -> {
                openFile(FILENAME)
                true
            }

            R.id.action_save -> {
                saveFile(FILENAME)
                true
            }

            R.id.action_settings -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    // Метод для открытия файла
    private fun openFile(fileName: String) {
        val textFromFile =
            File(applicationContext.filesDir, fileName)
                .bufferedReader()
                .use { it.readText() }
        editText.setText(textFromFile)
    }

    // Метод для сохранения файла
    private fun saveFile(fileName: String) {
        applicationContext.openFileOutput(fileName, Context.MODE_PRIVATE).use {
            it.write(editText.text.toString().toByteArray())
        }
        Toast.makeText(applicationContext, "Файл сохранён", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()

        val prefs = PreferenceManager
            .getDefaultSharedPreferences(this)
        val fontSize = prefs.getString(
            getString(R.string.pref_size), "20"
        )!!.toFloat()
// применяем настройки в текстовом поле
        editText.textSize = fontSize
        // читаем установленное значение из CheckBoxPreference
        if (prefs.getBoolean(getString(R.string.pref_openmode), false)) {
            openFile(FILENAME)
        }

        val regular = prefs.getString(getString(R.string.pref_style), "")
        var typeface = Typeface.NORMAL

        if (regular!!.contains("Полужирный")) typeface += Typeface.BOLD

        if (regular.contains("Курсив")) typeface += Typeface.ITALIC

// меняем настройки в EditText
        editText.setTypeface(null, typeface)
    }
}