package com.softychoo.camp.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.softychoo.camp.R
import com.softychoo.camp.bookmark.BookmarkFragment
import com.softychoo.camp.todo.TodoFragment

class MainViewPagerAdapter(
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {

    private val fragments = ArrayList<MainTabs>()

    init {
        fragments.add(
            MainTabs(TodoFragment.newInstance(), R.string.main_tab_todo_title)
        )
        fragments.add(
            MainTabs(BookmarkFragment.newInstance(), R.string.main_tab_bookmark_title),
        )
    }

//    fun getTodoFragment(): TodoFragment { //데이터를 넘겨주기 위햐여 fragments[0](TodoFragment)를 넘겨줌
//        return fragments[0].fragment as TodoFragment
//    }
//이름이 직관적이게

    //Fragment를 가져오는 코드를 index값으로 받아오도록
    fun getFragment(position: Int) :Fragment{
        return fragments[position].fragment
    }


    fun getTitle(position: Int): Int {
        return fragments[position].titleRes
    }

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position].fragment
    }
}