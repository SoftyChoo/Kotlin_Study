package com.example.myhotel

class Account() {
    fun account(array: Array<Array<String?>>) {
        println("조회하실 사용자 이름을 입력하세요")
        var name = readLine()!!.toString()
        for (i in 0..899) {
            if (array[i][0] == name) {
                println("방 " + array[i][1] + "호의 호텔 숙박비[" + array[i][4] + "원]의 10%인 예약금[" + array[i][5] + "원]이 출금되었습니다!")
            }
        }
    }
}