package com.softychoo.camp.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.google.android.material.tabs.TabLayoutMediator
import com.softychoo.camp.R
import com.softychoo.camp.TodoAdd.TodoAddActivity
import com.softychoo.camp.databinding.MainActivityBinding
import com.softychoo.camp.todo.TodoFragment

class MainActivity : AppCompatActivity() {


    private lateinit var binding: MainActivityBinding

    private lateinit var resultLauncher: ActivityResultLauncher<Intent> // registerForActivityResult

    private val viewPagerAdapter by lazy {
        MainViewPagerAdapter(this@MainActivity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        resultTodoItem() // registerForActivityResult
    }

    private fun initView() = with(binding) {
        toolBar.title = getString(R.string.app_name) // 툴바의 제목을 앱 이름으로 설정

        viewPager.adapter = viewPagerAdapter // ViewPager2의 어댑터 설정

        // TabLayout x ViewPager2를 TabLayoutMediator를 사용하여 연결
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            val text = tab.setText(viewPagerAdapter.getTitle(position))
        }.attach()





        binding.viewPager.registerOnPageChangeCallback( //fab [show/hide]
            object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    if (position == 0) {
                        fabAddTodo.show()
                    } else {
                        fabAddTodo.hide()
                    }
                }
            }
        )


        // fab
        fabAddTodo.setOnClickListener {
            val intentTodoAdd = Intent(this@MainActivity, TodoAddActivity::class.java)
            resultLauncher.launch(intentTodoAdd)
        }
    }

    // registerForActivityResult
    private fun resultTodoItem() {
        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) // 런처 생성
            { result ->
                if (result.resultCode == RESULT_OK) { //code값(RESULT_OK,RESULT_CANCELED)을 통해서 결과값을 여러 case로 받을 수 있다.
                    var itemTitle = result.data?.getStringExtra("input_title").toString()
                    var itemContent = result.data?.getStringExtra("input_content").toString()

                    val todoFragment = viewPagerAdapter.getTodoFragment() // Todo Fragment를 받아옴
                    // todo add Activity에서 받아온 데이터를 넘겨주자.
                    todoFragment.addData(itemTitle, itemContent)

                } else if (result.resultCode == RESULT_CANCELED) {
                    Toast.makeText(this, "종료", Toast.LENGTH_SHORT).show()
                }
            }
    }
}
