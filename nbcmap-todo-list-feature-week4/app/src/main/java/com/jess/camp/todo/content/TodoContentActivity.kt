package com.jess.camp.todo.content

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jess.camp.databinding.TodoAddActivityBinding
import com.jess.camp.todo.home.TodoModel


class TodoContentActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MODEL = "extra_model"

        //fun newIntent(context: Context) = Intent(context, TodoContentActivity::class.java)

        fun newIntentForAdd( // 등록
            context: Context
        ) = Intent(context, TodoContentActivity::class.java).apply {
            //...
        }
        fun newIntentForEdit( // 수정
            context: Context,
            //...
        ) = Intent(context, TodoContentActivity::class.java).apply {
            //...
        }
    }

    private lateinit var binding: TodoAddActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TodoAddActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() = with(binding) {

        toolBar.setNavigationOnClickListener {
            finish()
        }

        submit.setOnClickListener {
            val intent = Intent().apply {
                putExtra(
                    EXTRA_MODEL, TodoModel(
                        todoTitle.text.toString(),
                        todoDescription.text.toString()
                    )
                )
            }
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}