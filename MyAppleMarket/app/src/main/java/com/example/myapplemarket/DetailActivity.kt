package com.example.myapplemarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplemarket.Products.productList
import com.example.myapplemarket.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val position = intent.getIntExtra(MainActivity.PRODUCT_POSITION,0)
        val product = RecyclerViewAdaptor(productList).getItem(position)
        var isClicked = product.isClicked

//        val address = intent.getStringExtra(MainActivity.USER_ADDRESS)
//        val title = intent.getStringExtra(MainActivity.PRODUCT_TITLE)
//        val content = intent.getStringExtra(MainActivity.PRODUCT_CONTENT)
//        val price = intent.getIntExtra(MainActivity.PRODUCT_PRICE, 0)
//        val image = intent.getIntExtra(MainActivity.PRODUCT_IMAGE,0)
//        var isClicked = intent.getBooleanExtra(MainActivity.LIKE_IS_CLICKED, false)



        binding.apply {
            detailAddress.text = product.address
            detailTitle.text = product.title
            detialContent.text = product.content
            detailPrice.text = product.price.toString()
            detailImg.setImageResource(product.image)
            likestate(isClicked)

            detailLike.setOnClickListener {
                isClicked = !isClicked
                likestate(isClicked)
            }
        }

//        RecyclerViewAdaptor(productList).getItem()
    }

    private fun initView() = with(binding) {

    }
    private fun likestate(isClicked : Boolean)
    {
        if (isClicked) binding.detailLike.setImageResource(R.drawable.heart_fill)
        else binding.detailLike.setImageResource(R.drawable.heart)
    }

}