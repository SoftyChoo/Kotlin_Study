package com.softychoo.camp.TodoAdd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.Toolbar
import com.google.android.material.snackbar.Snackbar
import com.softychoo.camp.R
import com.softychoo.camp.main.MainActivity
import com.softychoo.camp.todo.TodoFragment
import com.softychoo.camp.todo.TodoListAdapter
import com.softychoo.camp.todo.TodoModel


class TodoAddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.todo_add_activity)

        val toolbar = findViewById<Toolbar>(R.id.tool_bar)
        val addBtn = findViewById<Button>(R.id.btn_registration)
        val etTitle = findViewById<EditText>(R.id.et_title)
        val etContent = findViewById<EditText>(R.id.et_content)

        setSupportActionBar(toolbar)
        val ab = supportActionBar!!

        ab.setHomeAsUpIndicator(R.drawable.baseline_arrow_back_24)//toolbar의 왼쪽에 backArrow 아이콘버튼을 넣음
        ab.setDisplayHomeAsUpEnabled(true)//아이콘을 보이게 만들어줌

        toolbar.setNavigationOnClickListener {//toolbar의 뒤로가기 아이콘 클릭 시 화면종료
            finish()
        }

        addBtn.setOnClickListener {
            val intentToMain = Intent(this,MainActivity::class.java)
            intentToMain.putExtra("input_title",etTitle.text)
            intentToMain.putExtra("input_content",etContent.text)
            startActivity(intentToMain)
            finish()
        }
    }


}