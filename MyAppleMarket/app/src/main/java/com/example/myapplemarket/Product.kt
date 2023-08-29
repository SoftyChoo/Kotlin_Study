package com.example.myapplemarket

data class Product(
    val image: Int,
    val title: String,
    val content: String,
    val nickname: String,
    val price: Int,
    val address: String,
    var like: Int,
    val chat: Int,
    var isClicked: Boolean
)