package com.jess.camp.todo.home

import android.icu.text.Transliterator.Position
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jess.camp.databinding.TodoFragmentBinding
import com.jess.camp.main.MainActivity
import com.jess.camp.todo.content.TodoContentActivity

class TodoFragment : Fragment() {

    companion object {
        fun newInstance() = TodoFragment()
    }

    private var _binding: TodoFragmentBinding? = null
    private val binding get() = _binding!!

    private val listAdapter by lazy {
        TodoListAdapter(this.itemClick)
    }
    private val itemClick = object : TodoListAdapter.OnItemClick {
        override fun onItemClick(view: View, item: TodoModel, position: Int) { // item, position
            (activity as? MainActivity)?.addToDoLauncher?.launch(TodoContentActivity.newIntentForEdit(context,item,position))
        }
    }
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

    }

    private fun initView() = with(binding) {
        todoList.adapter = listAdapter

    }
    fun setDodoContent(todoModel: TodoModel?) { //ADD
        listAdapter.addItem(todoModel)
    }

    fun removeContent(todoModel: TodoModel?) { //REMOVE
        listAdapter.removeItem(todoModel)
    }

    fun editContent(todoModel: TodoModel?,position : Int?){ //EDIT
        listAdapter.editItem(todoModel,position)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}