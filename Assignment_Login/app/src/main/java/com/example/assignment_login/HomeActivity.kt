package com.example.assignment_login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.Random

class HomeActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val finishBtn = findViewById<Button>(R.id.btn_finish)
        val name = findViewById<TextView>(R.id.tv_name)
        val id = findViewById<TextView>(R.id.tv_id)
        val age = findViewById<TextView>(R.id.tv_age)


        val changeImg = findViewById<ImageView>(R.id.iv_change)
        val num = rand(1, 5)
        when (num) {
                1 -> changeImg.setImageResource(R.drawable.jjang9)
                2 -> changeImg.setImageResource(R.drawable.jjanga)
                3 -> changeImg.setImageResource(R.drawable.mang9)
                4 -> changeImg.setImageResource(R.drawable.whitedog)
                5 -> changeImg.setImageResource(R.drawable.yuri)
        }




        finishBtn.setOnClickListener {
            finish()

        }
    }

    val random = Random()
    fun rand(from: Int, to: Int): Int {
        return random.nextInt(to - from) + from
    }
}