package com.example.customrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.customrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCv.setOnClickListener {
            val intentCV = Intent(this,CustomViewActivity::class.java)
            startActivity(intentCV)
        }
        binding.btnRv.setOnClickListener {
            val intentRV = Intent(this,RecyclerViewActivity::class.java)
            startActivity(intentRV)
        }

    }
}