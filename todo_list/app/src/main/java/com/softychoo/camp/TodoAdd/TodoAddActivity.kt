package com.softychoo.camp.TodoAdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import com.softychoo.camp.R

class TodoAddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.todo_add_activity)

        val toolbar = findViewById<Toolbar>(R.id.tool_bar)
        setSupportActionBar(toolbar)
        val ab = supportActionBar!!
        ab.setDisplayShowTitleEnabled(false)
        ab.setHomeAsUpIndicator(R.drawable.baseline_arrow_back_24)
        ab.setDisplayHomeAsUpEnabled(true)
    }
}