package com.example.myhotel

fun main() {

    var reserve = Reservation()
    var check = Check()
    var check_asc = Check_ASC()
    var account = Account()
    var change = Change()
    // 4x900 2차원 배열 선언 후 공백으로 초기화
    var array = Array(1000,{Array(4,{"Empty"})})
    var checkCount : Int = 0

    println("안녕하세요 호텔예약 프로그램 입니다.")
    while (true) {
        println("----------------------------------------------------------------------------------")
        println("[메뉴]\n1.방예약 2.예약목록출력 3.예약목록 정렬(오름차순) 4.시스템종료 5.입출금 내역 출력 6.예약 변경/취소")
        print("입력 : ")
        var menu = readLine()!!.toInt()

        when (menu) {
            1 -> {
                reserve.reserve(array)
                println("호텔 예약이 완료되었습니다.")
                checkCount++
            }

            2 -> {
                check.check(array,checkCount)
            }

            3 -> {
                check_asc.check_asc(array,checkCount)
            }

            4 -> {
                print("시스템을 종료합니다.")
                return
            }

            else -> println("올바르지 않은 값을 입력하였습니다. 다시 입력해주세요!")
        }
    }
}

class Reservation() {

    var today: String = "20230721"
    var count :Int = 100
    var room : String = ""
    var checkIn : String= ""
    var checkOut : String = ""
    fun reserve(array: Array<Array<String>>) {
        println("예약자분의 성함을 입력해주세요")
        var name = readLine()!!.toString()
        while(true){
            println("100~999사이의 예약할 방 번호를 입력해주세요")
            room = readLine()!!.toString()
            if (100 <= room.toInt() && room.toInt() <=999) break
        }
        while (true){
            println("체크인 날짜를 입력해주세요[오늘 날짜 : "+today+"]")
            checkIn = readLine()!!.toString()
            if(checkIn.toInt() <today.toInt()) println("지난 날짜는 예약이 불가능합니다.")
            else break
        }
        while (true)
        {
            println("체크아웃 날짜를 입력해주세요")
            checkOut = readLine()!!.toString()
            if(checkOut.toInt()<=checkIn.toInt()) println("체크인 이후의 날짜를 입력해주세요!")
            else break
        }

        array[count][0] = name
        array[count][1] = room
        array[count][2] = checkIn
        array[count][3] = checkOut
        count++
    }
}

class Check() {
    fun check(array: Array<Array<String>>, checkCount: Int) {
        println("호텔 예약자 목록입니다.")
        var count :Int = 1
        for(i in 100..999)
        {
            if(!(array[i][0] == "Empty")){
                println("${count++}. 사용자: "+array[i][0]+",방번호: "+array[i][1]+",체크인: "+array[i][2]+",체크아웃: "+array[i][3])
            }
        }
    }
}

class Check_ASC() {
    fun check_asc(array: Array<Array<String>>, checkCount: Int) {

    }
}

class Account() {
    fun account() {

    }
}

class Change() {
    fun change() {

    }
}
