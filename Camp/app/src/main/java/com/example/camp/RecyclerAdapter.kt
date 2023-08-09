package com.example.camp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RecyclerAdapter(val itemList: ArrayList<TodoData>) :
    RecyclerView.Adapter<RecyclerAdapter.BoardViewHolder>() {


    //위에서 만든 각 행 레이아웃(R.layout.item_recycler_view)를 인플레이트하여 뷰 홀더를 생성해 return 해준다.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view, parent, false)
        return BoardViewHolder(view)
    }
    //onCreateViewHolder는 리사이클러뷰가 만들어질때만 호출
    //onBindViewHolder는 스크롤을 내리거나 올릴때마다 호출

    //뷰가 바인드(Bind)될때 호출
    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
        holder.tv_title.text = itemList[position].title
    }
    //list의 수 return
    override fun getItemCount(): Int {
        return itemList.count()
    }
    inner class BoardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv_title = itemView.findViewById<TextView>(R.id.title)
    }
}