package com.example.helloworld

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onButton1Clicked(v:View) {
        Toast.makeText(this,"버튼1클릭 이벤트",Toast.LENGTH_SHORT).show()
        val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.naver.com/"))
        startActivity(myIntent)
    }
    fun onButton2Clicked(v:View) {
        Toast.makeText(this,"버튼2클릭 이벤트",Toast.LENGTH_SHORT).show()
        val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-2817-9282"))
        startActivity(myIntent)
    }
}