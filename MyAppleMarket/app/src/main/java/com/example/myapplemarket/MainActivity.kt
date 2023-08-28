package com.example.myapplemarket

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplemarket.Products.productList
import com.example.myapplemarket.databinding.ActivityMainBinding
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : AppCompatActivity() {
    companion object{
        val USER_ADDRESS = "address"
        val PRODUCT_TITLE = "title"
        val PRODUCT_CONTENT = "content"
        val PRODUCT_PRICE = "price"
        val LIKE_IS_CLICKED = "like"
        val PRODUCT_IMAGE = "image"
        val PRODUCT_POSITION = "position"
    }

    private  lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // recyclerView
        val adaptor = RecyclerViewAdaptor(productList) //itemClick을 위해 따로 선언
        binding.recyclerView.adapter = adaptor // 어댑터 연결
        binding.recyclerView.layoutManager = LinearLayoutManager(this) //RecyclerView 수직배치

        // recyclerView Click
        adaptor.productClick = object : RecyclerViewAdaptor.ProductClick{
            override fun onClick(view: View, position: Int) {
//                val product =  adaptor.getItem(position)//클릭 시 전송이 필요한 데이터를 받아옴
                intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra(PRODUCT_POSITION,position)
//                intent.apply {
//                    putExtra(USER_ADDRESS,product.address)
//                    putExtra(PRODUCT_TITLE,product.title)
//                    putExtra(PRODUCT_CONTENT,product.content)
//                    putExtra(PRODUCT_PRICE,product.price)
//                    putExtra(LIKE_IS_CLICKED,product.isClicked)
//                }
                startActivity(intent)
            }
        }

        // toolbar
        setSupportActionBar(binding.toolbarMain)
        binding.toolbarMain.setOnMenuItemClickListener { menuItem ->
            if(menuItem.itemId == R.id.item_notification) { //알림버튼이 눌렸을 때
                Toast.makeText(this,"알림기능 추가예정",Toast.LENGTH_SHORT).show()
                true
            }
            else false
        }
    }
    // 메뉴 리소스 XML의 내용을 앱바(App Bar)에 반영
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar,menu)
        return true
    }
}