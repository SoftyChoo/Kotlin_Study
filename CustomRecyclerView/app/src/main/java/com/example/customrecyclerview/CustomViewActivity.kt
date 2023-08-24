package com.example.customrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.customrecyclerview.Adaptor.CustomViewAdapter
import com.example.customrecyclerview.Data.MyItem
import com.example.customrecyclerview.databinding.ActivityCustomViewBinding

class CustomViewActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCustomViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 데이터 원본 준비
        val dataList = mutableListOf<MyItem>()
        dataList.add(MyItem(R.drawable.cat1, "Bella", "1"))
        dataList.add(MyItem(R.drawable.cat2, "Charlie", "2"))
        dataList.add(MyItem(R.drawable.cat3, "Daisy", "1.5"))
        dataList.add(MyItem(R.drawable.cat4, "Duke", "1"))
        dataList.add(MyItem(R.drawable.cat5, "Max", "2"))
        dataList.add(MyItem(R.drawable.cat6, "Happy", "4"))
        dataList.add(MyItem(R.drawable.cat7, "Luna", "3"))
        dataList.add(MyItem(R.drawable.cat8, "Bob", "2"))
        dataList.add(MyItem(R.drawable.cat9, "Mini", "1"))


        // 어댑터 생성 및 연결
        binding.listView.adapter = CustomViewAdapter(this, dataList)

        // 항목 클릭 이벤트 처리
        binding.listView.setOnItemClickListener{ parent, view, position, id ->
            val name: String = (binding.listView.adapter.getItem(position) as MyItem).aName
            Toast.makeText(this," $name 선택!", Toast.LENGTH_SHORT).show()
        }


    }
}