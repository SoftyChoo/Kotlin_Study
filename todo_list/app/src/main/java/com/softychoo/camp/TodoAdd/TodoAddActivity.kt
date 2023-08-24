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
import com.softychoo.camp.databinding.TodoAddActivityBinding
import com.softychoo.camp.main.MainActivity
import com.softychoo.camp.todo.TodoFragment
import com.softychoo.camp.todo.TodoListAdapter
import com.softychoo.camp.todo.TodoModel


class TodoAddActivity : AppCompatActivity() {

    private lateinit var binding : TodoAddActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = TodoAddActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolBar)
        val ab = supportActionBar!!

        ab.setHomeAsUpIndicator(R.drawable.baseline_arrow_back_24)//toolbar의 왼쪽에 backArrow 아이콘버튼을 넣음
        ab.setDisplayHomeAsUpEnabled(true)//아이콘을 보이게 만들어줌

        binding.toolBar.setNavigationOnClickListener {//toolbar의 뒤로가기 아이콘 클릭 시 화면종료
            setResult(RESULT_CANCELED)
            finish()
        }

        binding.btnRegistration.setOnClickListener {
            val intentToMain = Intent()
            intentToMain.putExtra("input_title",binding.etTitle.text.toString())
            intentToMain.putExtra("input_content",binding.etContent.text.toString())
            setResult(RESULT_OK,intentToMain)
            finish()
        }
    }


}