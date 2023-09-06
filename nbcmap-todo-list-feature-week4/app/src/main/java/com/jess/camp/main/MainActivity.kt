package com.jess.camp.main

import android.app.Activity
import android.os.Build
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.jess.camp.R
import com.jess.camp.databinding.MainActivityBinding
import com.jess.camp.todo.content.TodoContentActivity
import com.jess.camp.todo.home.TodoFragment
import com.jess.camp.todo.home.TodoModel
import com.jess.camp.todo.type.TodoContentType

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    private val viewPagerAdapter by lazy {
        MainViewPagerAdapter(this@MainActivity)
    }

    val addToDoLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            val todoFragment = viewPagerAdapter.getFragment(0) as? TodoFragment
            val todoModel = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                result.data?.getParcelableExtra(
                    TodoContentActivity.EXTRA_MODEL,
                    TodoModel::class.java
                )
            } else {
                result.data?.getParcelableExtra(
                    TodoContentActivity.EXTRA_MODEL
                )
            }
            // 같은 조건 when
            when (result.resultCode) {
                Activity.RESULT_OK -> { // ADD
                    todoFragment?.setDodoContent(todoModel)
                }

                TodoContentActivity.RESULT_EDIT -> { // EDIT
                    val position = result.data?.getIntExtra(TodoContentActivity.CONTENT_POSITION, 0)
                    todoFragment?.editContent(todoModel, position)
                }

                TodoContentActivity.RESULT_REMOVE -> { // REMOVE
                    todoFragment?.removeContent(todoModel)
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() = with(binding) {
        toolBar.title = getString(R.string.app_name)

        viewPager.adapter = viewPagerAdapter
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (viewPagerAdapter.getFragment(position) is TodoFragment) {
                    fabAddTodo.show()
                } else {
                    fabAddTodo.hide()
                }
            }
        })

        // TabLayout x ViewPager2
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.setText(viewPagerAdapter.getTitle(position))
        }.attach()

        // fab
        fabAddTodo.setOnClickListener {
            addToDoLauncher.launch(
                TodoContentActivity.newIntentForAdd(this@MainActivity)
            )
        }

    }
}