package com.falcon.gymlog_yaka

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val context = this
        CoroutineScope(Dispatchers.Default).launch{
            delay(2000)
            val landingIntent = Intent(context,LandingPageActivity::class.java)
            startActivity(landingIntent)
        }


    }
}