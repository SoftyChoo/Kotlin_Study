package com.jess.camp.main

import android.app.Activity
import android.os.Build
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.jess.camp.R
import com.jess.camp.bookmark.BookmarkFragment
import com.jess.camp.bookmark.BookmarkModel
import com.jess.camp.bookmark.toTodoModel
import com.jess.camp.databinding.MainActivityBinding
import com.jess.camp.todo.content.TodoContentActivity
import com.jess.camp.todo.home.TodoFragment
import com.jess.camp.todo.home.TodoModel
import com.jess.camp.todo.home.toBookmarkModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    private val viewPagerAdapter by lazy {
        MainViewPagerAdapter(this@MainActivity)
    }

    // 데이터 추가
    private val addTodoLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val todoModel = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    result.data?.getParcelableExtra(
                        TodoContentActivity.EXTRA_TODO_MODEL,
                        TodoModel::class.java
                    )
                } else {
                    result.data?.getParcelableExtra(
                        TodoContentActivity.EXTRA_TODO_MODEL
                    )
                }

                val todoFragment = viewPagerAdapter.getFragment(0) as? TodoFragment
                todoFragment?.setDodoContent(todoModel)
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
        viewPager.offscreenPageLimit = viewPagerAdapter.itemCount

        // TabLayout x ViewPager2
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.setText(viewPagerAdapter.getTitle(position))
        }.attach()

        // fab
        fabAddTodo.setOnClickListener {
            addTodoLauncher.launch(
                TodoContentActivity.newIntentForAdd(this@MainActivity)
            )
        }
    }

    fun addBookmarkItem(item: TodoModel) {
        val fragment = viewPagerAdapter.getFragment(1) as? BookmarkFragment
        fragment?.addItem(item.toBookmarkModel())
    }

    fun modifyTodoItem(item: BookmarkModel) {
        val fragment = viewPagerAdapter.getFragment(0) as? TodoFragment
        val todoItem = item.toTodoModel()
        fragment?.modifyTodoItem(
            item = todoItem
        )
    }
}