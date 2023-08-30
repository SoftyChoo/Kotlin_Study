package com.example.myapplemarket
import java.text.NumberFormat
import java.util.*

fun formatPrice(price: Int): String { // 천 단위로 콤마(,) 찍어 표시
    val formatter = NumberFormat.getNumberInstance(Locale.getDefault())
    return formatter.format(price)
}