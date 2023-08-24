package com.example.customrecyclerview.Adaptor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.customrecyclerview.Data.MyItem
import com.example.customrecyclerview.databinding.ItemRecyclerviewBinding

class RecyclerViewAdaptor(val mItems: MutableList<MyItem>) : RecyclerView.Adapter<RecyclerViewAdaptor.Holder>() {

    interface ItemClick { //인터페이스를 선언해서 Click시 데이터를 전달 Adaptora와 Activity사이의 통신(데이터 전달을 위해 만들어준다.)
        fun onClick(view : View, position : Int)
    }

    var itemClick : ItemClick? = null // 요기 예를 만듬

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.setOnClickListener {  //클릭이벤트추가부분
            itemClick?.onClick(it, position)
        }
        holder.iconImageView.setImageResource(mItems[position].aIcon)
        holder.name.text = mItems[position].aName
        holder.age.text = mItems[position].aAge
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    inner class Holder(val binding: ItemRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
        val iconImageView = binding.iconItem
        val name = binding.textItem1
        val age = binding.textItem2
    }
}