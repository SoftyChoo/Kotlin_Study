package com.example.camp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentPageAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 2 // 프래그먼트 개수
    }

    override fun createFragment(position: Int): Fragment {
        return if (position == 0)
            TodoFragment() // 첫 번째 위치에는 TodoFragment 생성
        else
            BookmarkFragment() // 두 번째 위치에는 BookmarkFragment 생성
    }
}