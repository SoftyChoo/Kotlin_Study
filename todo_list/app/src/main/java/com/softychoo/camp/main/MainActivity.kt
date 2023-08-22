package com.softychoo.camp.main

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayoutMediator
import com.softychoo.camp.R
import com.softychoo.camp.TodoAdd.TodoAddActivity
import com.softychoo.camp.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    private val viewPagerAdapter by lazy {
        MainViewPagerAdapter(this@MainActivity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() = with(binding) {
        // 툴바의 제목을 앱 이름으로 설정
        toolBar.title = getString(R.string.app_name)

        // ViewPager2의 어댑터 설정
        viewPager.adapter = viewPagerAdapter

        // TabLayout x ViewPager2를 TabLayoutMediator를 사용하여 연결
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.setText(viewPagerAdapter.getTitle(position))
        }.attach()

        // fab
        fabAddTodo.setOnClickListener {
                val intentTodoAdd = Intent(this@MainActivity,TodoAddActivity::class.java)
                startActivity(intentTodoAdd)
        }
    }
}