package com.example.viewbinding

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class ImageAdaptor : BaseAdapter() {

    private val mThumbIds = arrayOf<Int>(
        R.drawable.cat1, R.drawable.cat2,
        R.drawable.cat3, R.drawable.cat4,
        R.drawable.cat5, R.drawable.cat6,
        R.drawable.cat7, R.drawable.cat8,
        R.drawable.cat9
    )

    override fun getCount(): Int {
        TODO("Not yet implemented")
    }

    override fun getItem(position: Int): Any {
        TODO("Not yet implemented")
    }

    override fun getItemId(position: Int): Long {
        TODO("Not yet implemented")
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        TODO("Not yet implemented")
    }
}