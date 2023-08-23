package com.example.viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.viewbinding.databinding.ActivityGridviewBinding

class ImgGridviewActivity : AppCompatActivity() {

    private lateinit var GVbinding : ActivityGridviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        GVbinding = ActivityGridviewBinding.inflate(layoutInflater)
        setContentView(GVbinding.root)
    }

}