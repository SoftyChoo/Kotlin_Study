package com.example.camp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
/**
 * A simple [Fragment] subclass.
 * Use the [TodoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

interface MemoListener{
    fun addMemo(memo : String)
}
class TodoFragment : Fragment(),MemoListener{

    private val itemList = ArrayList<TodoData>()
    private val recyclerAdapter = RecyclerAdapter(itemList)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Fragment를 MainActivity에 연결
        (activity as MainActivity).addListener(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val view = inflater.inflate(R.layout.fragment_todo, container, false)
        // Inflate the layout for this fragment
        val rv_board = view.findViewById<RecyclerView>(R.id.recycler_view)

        rv_board.adapter = recyclerAdapter
        rv_board.layoutManager = LinearLayoutManager(MainActivity(), LinearLayoutManager.VERTICAL, false)

        return view
    }
    override fun addMemo(memo: String) {
        itemList.add(TodoData(memo))
        recyclerAdapter.notifyDataSetChanged()
    }
}



//        itemList.add(TodoData("TODO"))
//        itemList.add(TodoData("TODO"))
//        recyclerAdapter.notifyDataSetChanged()