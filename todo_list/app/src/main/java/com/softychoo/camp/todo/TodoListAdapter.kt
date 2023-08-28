package com.softychoo.camp.todo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.softychoo.camp.databinding.TodoItemBinding

class TodoListAdapter : RecyclerView.Adapter<TodoListAdapter.ViewHolder>() {


    private val list = ArrayList<TodoModel>()

    fun addItem(title:String, content:String) {
        //list.addAll(listOf(TodoModel(title,content)))
        list.add(TodoModel(title,content))
        notifyItemChanged(list.size-1) //리스트의 마지막에 추가되게
        //notifyDataSetChanged()
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
    }

    class ViewHolder(
        private val binding: TodoItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: TodoModel) = with(binding) {
            title.text = item.title
            content.text = item.content
        }
    }

 //데이터 이동 Activity -> fragment / 아키텍쳐를 적용할 예정 -> 미래지향적인 코드로 이어짐
 // mvvm viewmodel 통신 -> 불필요한 로직 줄어듬 / UI로직을 안하고 통신에 필요한것만 (간섭이 사라짐) / 장점은 간섭이 줄어들어 유지보수성 향상
}