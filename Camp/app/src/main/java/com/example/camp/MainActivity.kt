// MainActivity.kt
package com.example.camp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager2: ViewPager2
    private lateinit var adapter : FragmentPageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 뷰 초기화
        tabLayout = findViewById(R.id.tab)
        viewPager2 = findViewById(R.id.viewPager)

        // FragmentPageAdapter 인스턴스 생성
        adapter = FragmentPageAdapter(supportFragmentManager, lifecycle)

        // TabLayout에 탭 추가
        tabLayout.addTab(tabLayout.newTab().setText("Todo"))
        tabLayout.addTab(tabLayout.newTab().setText("Bookmark"))

        // 어댑터를 ViewPager2에 설정
        viewPager2.adapter = adapter

        // 탭 선택 변경 리스너 추가
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    // 탭 선택 시, ViewPager2의 현재 페이지 변경
                    viewPager2.currentItem = tab.position
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })

        // ViewPager2 페이지 변경 콜백 리스너 추가
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                // 페이지 선택 시, TabLayout에서 해당 탭 선택
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        })
    }
}
