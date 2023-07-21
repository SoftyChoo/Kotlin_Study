package com.example.myhotel

import java.util.Random

class Reservation() {

    var today: String = "20230721"
    var room : String = ""
    var checkIn : String= ""
    var checkOut : String = ""

    val random = Random()
    fun rand(from: Int, to: Int) : Int {
        return random.nextInt(to - from) + from
    }
    fun reserve(array: Array<Array<String?>>) {
        println("예약자분의 성함을 입력해주세요")
        var name = readLine()!!.toString()

        while (true)
        {
            //예약날짜 겹치면 안되게 구현 예정
            break
        }
        while(true){
            println("100~999사이의 예약할 방 번호를 입력해주세요")
            room = readLine()!!.toString()
            if (100 <= room.toInt() && room.toInt() <=999) break
        }
        while (true){
            println("체크인 날짜를 입력해주세요[오늘 날짜 : "+today+"],[입력형식:20230502]")
            checkIn = readLine()!!.toString()
            if(checkIn.toInt() <today.toInt()) println("지난 날짜는 예약이 불가능합니다.")
            else break
        }
        while (true)
        {
            println("체크아웃 날짜를 입력해주세요 ,[입력형식:20230502]")
            checkOut = readLine()!!.toString()
            if(checkOut.toInt()<=checkIn.toInt()) println("체크인 이후의 날짜를 입력해주세요!")
            else break
        }
        for(i in 0..899)
        {
            if(array[i][0]==null){
                array[i][0] = name
                array[i][1] = room
                array[i][2] = checkIn
                array[i][3] = checkOut
                array[i][4] = rand(500000,600000).toString() //호텔 숙소비
                array[i][5] = (array[i][4]!!.toInt() * 0.1).toString() // 호텔 숙박비의 10% 예약금

                println("호텔 숙박비["+array[i][4]+"원]의 10%인 예약금["+array[i][5]+"원]을 입금해주세요!")
                break
            }
        }
    }
}