package com.oguzel.omer_guzel_week6_hw6

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val counter: TextView = findViewById(R.id.textViewCounter)

        while (true) {
            CoroutineScope(Dispatchers.IO).launch {
                var i = 0
//                while (true){
                val answer = doNetworkCall()
                withContext(Dispatchers.Main) {
                    counter.text = i.toString()
                    i++
                    Log.v("PATIKA", answer)
                }
//                }
            }
        }
    }

    suspend fun doNetworkCall(): String {
        delay(1000L)
        return "Network Answer Called"
    }
}