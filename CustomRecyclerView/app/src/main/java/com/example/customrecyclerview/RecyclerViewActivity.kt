package com.example.customrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.customrecyclerview.Adaptor.RecyclerViewAdaptor
import com.example.customrecyclerview.Data.MyItem
import com.example.customrecyclerview.databinding.ActivityRecyclerViewBinding

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var binding :ActivityRecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
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

        dataList.add(MyItem(R.drawable.cat1, "Bella", "1"))
        dataList.add(MyItem(R.drawable.cat2, "Charlie", "2"))
        dataList.add(MyItem(R.drawable.cat3, "Daisy", "1.5"))
        dataList.add(MyItem(R.drawable.cat4, "Duke", "1"))
        dataList.add(MyItem(R.drawable.cat5, "Max", "2"))
        dataList.add(MyItem(R.drawable.cat6, "Happy", "4"))
        dataList.add(MyItem(R.drawable.cat7, "Luna", "3"))
        dataList.add(MyItem(R.drawable.cat8, "Bob", "2"))
        dataList.add(MyItem(R.drawable.cat9, "Mini", "1"))

        dataList.add(MyItem(R.drawable.cat1, "Bella", "1"))
        dataList.add(MyItem(R.drawable.cat2, "Charlie", "2"))
        dataList.add(MyItem(R.drawable.cat3, "Daisy", "1.5"))
        dataList.add(MyItem(R.drawable.cat4, "Duke", "1"))
        dataList.add(MyItem(R.drawable.cat5, "Max", "2"))
        dataList.add(MyItem(R.drawable.cat6, "Happy", "4"))
        dataList.add(MyItem(R.drawable.cat7, "Luna", "3"))
        dataList.add(MyItem(R.drawable.cat8, "Bob", "2"))
        dataList.add(MyItem(R.drawable.cat9, "Mini", "1"))

        dataList.add(MyItem(R.drawable.cat1, "Bella", "1"))
        dataList.add(MyItem(R.drawable.cat2, "Charlie", "2"))
        dataList.add(MyItem(R.drawable.cat3, "Daisy", "1.5"))
        dataList.add(MyItem(R.drawable.cat4, "Duke", "1"))
        dataList.add(MyItem(R.drawable.cat5, "Max", "2"))
        dataList.add(MyItem(R.drawable.cat6, "Happy", "4"))
        dataList.add(MyItem(R.drawable.cat7, "Luna", "3"))
        dataList.add(MyItem(R.drawable.cat8, "Bob", "2"))
        dataList.add(MyItem(R.drawable.cat9, "Mini", "1"))

        //어댑터 생성 및 연결
        val adapter = RecyclerViewAdaptor(dataList) // itemClick을 사용하기 위하여 Adaptor을 따로 선언 :)
        binding.recycelrView.adapter = adapter

        binding.recycelrView.layoutManager = LinearLayoutManager(this)//Recyclerview 수직배치

        //클릭 이벤트 처리
        adapter.itemClick = object : RecyclerViewAdaptor.ItemClick {
            override fun onClick(view: View, position: Int) {
                val name: String = dataList[position].aName
                Toast.makeText(this@RecyclerViewActivity," $name 선택!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}