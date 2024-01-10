package ru.sofah.catalog

import android.content.Context
import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader


class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val webView: WebView = findViewById(R.id.webView)

        val intent = intent
        val resName = "n${intent.getIntExtra("title", 0)}"
        val resId = resources.getIdentifier(resName, "raw", packageName) // использование packageName

        if (resId != 0) {
            val text: String = readRawTextFile(this, resId)
            webView.loadDataWithBaseURL(null, text, "text/html", "UTF-8", null)
        } else {
            // Ресурс не найден, обработайте эту ситуацию по своему усмотрению
        }
    }

    private fun readRawTextFile(context: Context, resId: Int): String {
        val inputStream: InputStream = context.resources.openRawResource(resId)
        val reader = BufferedReader(InputStreamReader(inputStream))
        return reader.use { it.readText() }
    }
}