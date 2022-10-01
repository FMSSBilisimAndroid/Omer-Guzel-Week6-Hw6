# Coroutine Experiment

## Can coroutine counter in an infinite loop return results?

```
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
```
Experimented code is shown above.

This code is not able to return any results via log or UI. Since ```while(true)``` loop is being operated in main thread, coroutine will be suspended until loop will end. Thus it gets <ins>stuck</ins>. Commenting outer ```while``` loop and activating inner loop will result with intended results.




