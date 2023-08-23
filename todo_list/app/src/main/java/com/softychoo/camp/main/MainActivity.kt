package com.softychoo.camp.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.softychoo.camp.R
import com.softychoo.camp.TodoAdd.TodoAddActivity
import com.softychoo.camp.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {
//    private lateinit var itemTitle : String
//    private lateinit var itemContent : String


    private lateinit var binding: MainActivityBinding

    // registerForActivityResult
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    // registerForActivityResult

    private val viewPagerAdapter by lazy {
        MainViewPagerAdapter(this@MainActivity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()

        // registerForActivityResult
        resultTodoItem()
        // registerForActivityResult
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
            val intentTodoAdd = Intent(this@MainActivity, TodoAddActivity::class.java)
            resultLauncher.launch(intentTodoAdd)

//                startActivity(intentTodoAdd)
        }
    }

    // registerForActivityResult
    private fun resultTodoItem() {
        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        { result ->
            var itemTitle = result.data?.getStringExtra("title").toString() //?: ""
            var itemContent = result.data?.getStringExtra("content").toString() //?: ""
            //listener?.addItems(itemTitle,itemContent)
        }

    }
    // registerForActivityResult
}
