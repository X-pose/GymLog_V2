package com.falcon.gymlog_yaka

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class LandingPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page)

        val imgViewAcc = findViewById<ImageView>(R.id.imgViewAcc)
        val imgViewHealth = findViewById<ImageView>(R.id.imgViewHealth)
        val imgViewList = findViewById<ImageView>(R.id.imgViewList)

        imgViewList.setImageResource(R.drawable.selected_list)

        imgViewAcc.setOnClickListener(){
            imgViewAcc.setImageResource(R.drawable.selected_account)
            imgViewHealth.setImageResource(R.drawable.unselected_health)
            imgViewList.setImageResource(R.drawable.unselected_list)

            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainerViewID,AccountViewFragment())
                commit()
            }

        }

        imgViewHealth.setOnClickListener(){
            imgViewAcc.setImageResource(R.drawable.unselected_account)
            imgViewHealth.setImageResource(R.drawable.selected_health)
            imgViewList.setImageResource(R.drawable.unselected_list)

            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainerViewID,BMIFragment())
                commit()
            }

        }

        imgViewList.setOnClickListener(){
            imgViewAcc.setImageResource(R.drawable.unselected_account)
            imgViewHealth.setImageResource(R.drawable.unselected_health)
            imgViewList.setImageResource(R.drawable.selected_list)

            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainerViewID,ScheduleViewFragment())
                commit()
            }

        }


    }
}