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
        val mbti = findViewById<TextView>(R.id.tv_mbti)

        val user_name = intent.getStringExtra("user_name")
        val user_id = intent.getStringExtra("user_id")
        val user_age = intent.getStringExtra("user_age")
        val user_mbti = intent.getStringExtra("user_mbti")

        name.setText(user_name)
        id.setText(user_id)
        age.setText(user_age)
        mbti.setText(user_mbti)


        val changeImg = findViewById<ImageView>(R.id.iv_change)
        changeImg.clipToOutline = true
        val num = rand(1, 6)
        when (num) {
            1 -> changeImg.setImageResource(R.drawable.me1)
            2 -> changeImg.setImageResource(R.drawable.cat1)
            3 -> changeImg.setImageResource(R.drawable.cat2)
            4 -> changeImg.setImageResource(R.drawable.cat3)
            5 -> changeImg.setImageResource(R.drawable.cat4)
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