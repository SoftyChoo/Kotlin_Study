package com.example.myapplemarket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplemarket.databinding.ItemProductBinding

class RecyclerViewAdaptor(private val productList: MutableList<Product>) :
    RecyclerView.Adapter<RecyclerViewAdaptor.Holder>() {

    var productClick: ProductClick? = null

    interface ProductClick {
        fun onClick(view: View, position: Int)
    }

    var productLongClick: ProductLongClick? = null

    interface ProductLongClick {
        fun onLongClick(view: View, position: Int)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.setOnClickListener {  // 클릭 이벤트 추가 부분
            productClick?.onClick(it, position)
        }
        holder.itemView.setOnLongClickListener {  // long클릭 이벤트 추가
            productLongClick?.onLongClick(it, position)
            true
        }

        holder.image.setImageResource(productList[position].image)
        holder.title.text = productList[position].title
        holder.address.text = productList[position].address
        holder.price.text = productList[position].price.toString()
        holder.chat.text = productList[position].chat.toString()
        holder.like.text = productList[position].like.toString()
    }
//        val numberFormat = NumberFormat.getNumberInstance(Locale.KOREA) // 천의 자리마다 쉼표 추가
//        holder.price.text = numberFormat.format(productList[position].price.toString())

    fun getItem(position: Int) = productList[position]

    fun delItem(position: Int) {
        productList.removeAt(position)
        notifyDataSetChanged()
    }

    fun reFreshItem(position: Int, isClicked: Boolean, firstState: Boolean?) {

        if (isClicked != firstState) {
            if (isClicked) productList[position].like += 1
            else productList[position].like -= 1
        }
        notifyItemChanged(position)
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