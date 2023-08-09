package com.example.camp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    //-----------------------------------------//
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager2: ViewPager2
    private lateinit var adapter : FragmentPageAdapter
    //-----------------------------------------//
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout = findViewById(R.id.tab)
        viewPager2 = findViewById(R.id.viewPager)

        adapter = FragmentPageAdapter(supportFragmentManager, lifecycle)

        tabLayout.addTab(tabLayout.newTab().setText("Todo"))
        tabLayout.addTab(tabLayout.newTab().setText("Bookmark"))

        viewPager2.adapter = adapter

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null)
                {
                    viewPager2.currentItem = tab.position
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tabLayout.selectTab((tabLayout.getTabAt(position)))
            }
        })

        //------------------------------------------------------------//
        //FragmentAdatper 객체인 pageAdapter를 ViewPager의 Adpater로 연결 후
        //ViewPager와 Tab을 setupWithViewPager로 연결해준다.
//        val pagerAdapter = FragmentAdapter(supportFragmentManager)
//        val pager = findViewById<ViewPager>(R.id.viewPager)
//        val tab = findViewById<TabLayout>(R.id.tab)
//        pager.adapter = pagerAdapter
//        tab.setupWithViewPager(pager)
        //------------------------------------------------------------//

    }
}