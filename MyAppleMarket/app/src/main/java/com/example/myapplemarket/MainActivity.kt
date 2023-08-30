package com.example.myapplemarket

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplemarket.Products.productList
import com.example.myapplemarket.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        //        val USER_ADDRESS = "address"
//        val PRODUCT_TITLE = "title"
//        val PRODUCT_CONTENT = "content"
//        val PRODUCT_PRICE = "price"
//        val LIKE_IS_CLICKED = "like"
//        val PRODUCT_IMAGE = "image"
        val PRODUCT_POSITION = "position"
    }

    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptor: RecyclerViewAdaptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // recyclerView
        adaptor = RecyclerViewAdaptor(productList) //itemClick을 위해 따로 선언
        binding.recyclerView.adapter = adaptor // 어댑터 연결
        binding.recyclerView.layoutManager = LinearLayoutManager(this) //RecyclerView 수직배치

        // recyclerView Click
        adaptor.productClick = object : RecyclerViewAdaptor.ProductClick {
            override fun onClick(view: View, position: Int) {
                intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra(PRODUCT_POSITION, position)
                resultLauncher.launch(intent)
            }
        }
        // recyclerView LongClick
        adaptor.productLongClick = object : RecyclerViewAdaptor.ProductLongClick {
            override fun onLongClick(view: View, position: Int) {
                itemLongClickDialog(position)
            }
        }

        // toolbar
        setSupportActionBar(binding.toolbarMain)
        binding.toolbarMain.setOnMenuItemClickListener { menuItem ->
            if (menuItem.itemId == R.id.item_notification) { //알림버튼이 눌렸을 때
                notification(context = this)
                Toast.makeText(this, "알림이 도착하였습니다.", Toast.LENGTH_SHORT).show()
                true
            } else false
        }

        //fab [show/hide]
        binding.recyclerView.addOnScrollListener(
            object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    if (dy > 0) binding.fabMain.show()
                    else binding.fabMain.hide()
                }
            }
        )

        // fab
        binding.fabMain.setOnClickListener {
            binding.recyclerView.smoothScrollToPosition(0) // smooth를 넣어 스르르 올라가게
        }


        resultItem() // registerForActivityResult
        onBackPressedDispatcher.addCallback(
            this@MainActivity,
            onBackPressedCallbackMain
        ) // OnBackPressedCallBack

    }

    // 메뉴 리소스 XML의 내용을 앱바(App Bar)에 반영
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    private fun resultItem() {
        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) // 런처 생성
            { result ->
                if (result.resultCode == RESULT_OK) { //code값(RESULT_OK,RESULT_CANCELED)을 통해서 결과값을 여러 case로 받을 수 있다.
                    val isClicked =
                        result.data?.getBooleanExtra(DetailActivity.LIKE_IS_CLICKED, false)
                    val position = result.data?.getIntExtra(PRODUCT_POSITION, 0)
                    val firstState =
                        result.data?.getBooleanExtra(DetailActivity.LIKE_IS_CLICKED_STATE, false)
                    if (position != null && isClicked != null) {
                        adaptor.reFreshItem(position, isClicked, firstState)
                    }
                } else if (result.resultCode == RESULT_CANCELED) {
                }
            }
    }

    private fun itemLongClickDialog(position:Int){
        var builder = AlertDialog.Builder(this@MainActivity)
        builder.setTitle("상품 삭제")
        builder.setMessage("상품을 정말로 삭제하시겠습니까?")
        builder.setIcon(R.drawable.bubble_chat)

        // 버튼 클릭시에 무슨 작업을 할 것인가!
        val listener = object : DialogInterface.OnClickListener {
            override fun onClick(p0: DialogInterface?, p1: Int) {
                when (p1) {
                    DialogInterface.BUTTON_POSITIVE -> adaptor.delItem(position)
                    DialogInterface.BUTTON_NEGATIVE -> p0?.dismiss()
                }
            }
        }
        builder.setPositiveButton("확인", listener)
        builder.setNegativeButton("취소", listener)
        builder.show()
    }

    private val onBackPressedCallbackMain = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            var builder = AlertDialog.Builder(this@MainActivity)
            builder.setTitle("종료")
            builder.setMessage("정말로 종료 하시겠습니까?")
            builder.setIcon(R.drawable.bubble_chat)

            // 버튼 클릭시에 무슨 작업을 할 것인가!
            val listener = object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    when (p1) {
                        DialogInterface.BUTTON_POSITIVE -> finish()
                        DialogInterface.BUTTON_NEGATIVE -> p0?.dismiss()
                    }
                }
            }
            builder.setPositiveButton("확인", listener)
            builder.setNegativeButton("취소", listener)
            builder.show()
        }
    }


}