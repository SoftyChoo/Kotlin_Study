package com.softychoo.camp.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.softychoo.camp.databinding.TodoFragmentBinding
import com.softychoo.camp.main.MainActivity

class TodoFragment : Fragment(){

    companion object {
        fun newInstance() = TodoFragment()
    }

    private var _binding: TodoFragmentBinding? = null
    private val binding get() = _binding!!

    private val listAdapter by lazy {
        TodoListAdapter()
    }

    //add
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        (activity as MainActivity).addListener(this)
    }
    //add

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = TodoFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()

//         for test
//        val testList = arrayListOf<TodoModel>()
//        for (i in 0 until 100) {
//            testList.add(
//                TodoModel(
//                    id = i,
//                    "Todo Title $i",
//                    "Todo Content $i"
//                )
//            )
//        }
//        listAdapter.addItems(testList)

//        listAdapter.addItem(title,content)

    }

    private fun initView() = with(binding) {
        todoList.adapter = listAdapter
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}