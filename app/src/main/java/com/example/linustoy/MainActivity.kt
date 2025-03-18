package com.example.linustoy

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.util.Log
import android.widget.Button
import com.google.android.material.datepicker.DateValidatorPointBackward
import com.google.android.material.datepicker.DateValidatorPointForward
import java.net.HttpURLConnection
import java.net.URL


class MainActivity : AppCompatActivity() {

    private lateinit var hootbtn: Button
    private lateinit var forwardbtn: Button
    private lateinit var backward: Button
    private lateinit var leftbtn:Button
    private lateinit var rightbtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        hootbtn = findViewById(R.id.btnHoot)
        forwardbtn = findViewById(R.id.btnForwards)
        backward = findViewById(R.id.btnBackwards)
        leftbtn = findViewById(R.id.btnLeft)
        rightbtn = findViewById(R.id.btnRight)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        hootbtn.setOnClickListener{
            Log.e("MainActivity", "Hoot Button pressed") // Log button press

            val url = "http://192.168.4.1/weg;jbfeW;HOUBwfe;buiowfe"

            // Send the HTTP request
            sendHttpRequest(url)
        }

        forwardbtn.setOnClickListener{
            Log.e("MainActivity", "Forward Button pressed") // Log button press

            val url = "http://192.168.4.1/fore"

            // Send the HTTP request
            sendHttpRequest(url)
        }

        forwardbtn.setOnClickListener{
            Log.e("MainActivity", "Forward Button pressed") // Log button press

            val url = "http://192.168.4.1/back"

            // Send the HTTP request
            sendHttpRequest(url)
        }

        leftbtn.setOnClickListener{
            Log.e("MainActivity", "Left Button pressed") // Log button press

            val url = "http://192.168.4.1/left"

            // Send the HTTP request
            sendHttpRequest(url)
        }

        rightbtn.setOnClickListener{
            Log.e("MainActivity", "Right Button pressed") // Log button press

            val url = "http://192.168.4.1/right"

            // Send the HTTP request
            sendHttpRequest(url)
        }



    }

    private fun sendHttpRequest(url: String) {
        Thread {
            try {
                val connection = URL(url).openConnection() as HttpURLConnection
                connection.requestMethod = "GET" // Set HTTP method
                connection.connect()

                val responseCode = connection.responseCode
                val responseMessage = connection.responseMessage

                Log.e("sendHttpRequest", "Response: $responseCode - $responseMessage")

            } catch (e: Exception) {
                Log.e("sendHttpRequest", "Error: ${e.message}")
            }
        }.start() // Run the HTTP request in a background thread
    }


}