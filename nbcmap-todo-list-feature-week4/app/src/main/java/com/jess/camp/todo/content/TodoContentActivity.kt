package com.jess.camp.todo.content

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.jess.camp.R
import com.jess.camp.databinding.TodoAddActivityBinding
import com.jess.camp.todo.home.TodoListAdapter
import com.jess.camp.todo.home.TodoModel
import com.jess.camp.todo.type.TodoContentType


class TodoContentActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MODEL = "extra_model"
        const val RESULT_EDIT = 3
        const val RESULT_REMOVE = 5
        const val CONTENT_POSITION = "content_position"
        //const val TYPE_ADD = "type_add"
        //const val TYPE_EDIT = "type_edit"


        private lateinit var entryType: Enum<TodoContentType>
        private lateinit var modifyItem: TodoModel
        private var contentPosition = 0
        fun newIntentForAdd( // ADD INTENT
            context: Context
        ) = Intent(context, TodoContentActivity::class.java).apply {
            entryType = TodoContentType.ADD
        }

        fun newIntentForEdit( // EDIT INTENT
            context: Context?,
            item: TodoModel,
            position: Int
        ) = Intent(context, TodoContentActivity::class.java).apply {
            entryType = TodoContentType.EDIT
            modifyItem = item
            contentPosition = position
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

        remove.visibility = View.GONE // 삭제버튼 show()/hide()
        if (entryType == TodoContentType.EDIT) {
            submit.setText(R.string.todo_modify)
            todoTitle.setText(modifyItem.title)
            todoDescription.setText(modifyItem.description)
            remove.visibility = View.VISIBLE
        }


        toolBar.setNavigationOnClickListener {
            finish()
        }

        remove.setOnClickListener {
            basicDialog()
        }

        submit.setOnClickListener { // 등록or수정 btn
            val intent = Intent().apply {
                putExtra(
                    EXTRA_MODEL,
                    TodoModel(todoTitle.text.toString(), todoDescription.text.toString())
                )
                if (entryType == TodoContentType.EDIT) putExtra(CONTENT_POSITION, contentPosition) // edit
            }
            if (entryType == TodoContentType.ADD) setResult(Activity.RESULT_OK, intent) // ADD
            else if (entryType == TodoContentType.EDIT) setResult(RESULT_EDIT, intent) // EDIT
            finish()
        }
    }

    private fun basicDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("할 일을 삭제할까요?")

        val listener = DialogInterface.OnClickListener { p0, p1 ->
            when (p1) {
                DialogInterface.BUTTON_POSITIVE -> {
                    val intent = Intent().apply {
                        putExtra(
                            EXTRA_MODEL,
                            TodoModel(
                                binding.todoTitle.text.toString(),
                                binding.todoDescription.text.toString()
                            )
                        )
                    }
                    setResult(RESULT_REMOVE, intent) // REMOVE
                    finish()
                }

                DialogInterface.BUTTON_NEGATIVE -> p0?.dismiss()
            }
        }
        builder.setPositiveButton("삭제", listener)
        builder.setNegativeButton("취소", listener)
        builder.show()
    }
}