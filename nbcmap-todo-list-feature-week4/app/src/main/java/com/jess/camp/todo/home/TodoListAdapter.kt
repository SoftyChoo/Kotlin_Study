package com.jess.camp.todo.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jess.camp.databinding.TodoItemBinding

class TodoListAdapter(private val itemClick: OnItemClick) :
    RecyclerView.Adapter<TodoListAdapter.ViewHolder>() {

    private val list = ArrayList<TodoModel>()

    //private lateinit var itemClick: OnItemClick
    //ItemClick을 넘겨줌
    interface OnItemClick{
        fun onItemClick(view: View, item: TodoModel, position: Int)
    }

    fun addItem(todoModel: TodoModel?) { // ADD
        if (todoModel == null) {
            return
        }
        list.add(todoModel)
        notifyItemChanged(list.size - 1)
    }

    fun removeItem(item: TodoModel?){ // REMOVE
        list.removeIf{it == item}
        notifyDataSetChanged()
    }

    fun editItem(item: TodoModel?,position: Int?){ //EDIT
        if (item != null && position != null) {
            list[position].title = item.title
            list[position].description = item.description
            notifyItemChanged(position)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            TodoItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)

        holder.itemView.setOnClickListener { //Click
            itemClick.onItemClick(it,item,position)
        }
    }

    class ViewHolder(
        private val binding: TodoItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: TodoModel) = with(binding) {
            title.text = item.title
            description.text = item.description
        }
    }
}