package com.example.myapplemarket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplemarket.databinding.ItemProductBinding

class RecyclerViewAdaptor(val productList: MutableList<Product>) :
    RecyclerView.Adapter<RecyclerViewAdaptor.Holder>() {


    interface ProductClick {
        fun onClick(view: View, position: Int)
    }

    var productClick: ProductClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)

    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.setOnClickListener {  //클릭이벤트추가부분
            productClick?.onClick(it, position)
        }
        holder.image.setImageResource(productList[position].image)
        holder.image.clipToOutline = true
        holder.title.text = productList[position].title
        holder.address.text = productList[position].address
        holder.price.text = productList[position].price.toString()
        holder.chat.text = productList[position].chat.toString()
        holder.like.text = productList[position].like.toString()
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    inner class Holder(val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {
        val image = binding.imageView
        val title = binding.tvTitle
        val address = binding.tvAddress
        val price = binding.tvPrice
        val chat = binding.tvChat
        val like = binding.tvLike
    }
}