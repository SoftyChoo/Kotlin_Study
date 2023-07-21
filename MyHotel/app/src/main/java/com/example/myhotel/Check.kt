package com.example.myhotel

class Check() {
    fun check(array: Array<Array<String?>>) {
        println("호텔 예약자 목록입니다.")
        var count = 1
        for(i in 0..899)
        {
            if(array[i][0]!=null)
            {
                println("${count++}. 사용자: "+array[i][0]+",방번호: "+array[i][1]+",체크인: "+array[i][2]+",체크아웃: "+array[i][3])
            }
        }
    }
}