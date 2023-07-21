
package com.example.myhotel

fun main() {

    var roomPerson = HashMap<String, String>()
    var roomCheckIn = HashMap<String, String>()
    var roomCheckOut = HashMap<String, String>()
    var reserve = Reservation()
    var check = Check()
    var check_asc = Check_ASC()
    var account = Account()
    var change = Change()


    println("안녕하세요 호텔예약 프로그램 입니다.")
    while (true) {
        println("[메뉴]\n1.방예약 2.예약목록출력 3.예약목록 정렬(오름차순) 4.시스템종료 5.입출금 내역 출력 6.예약 변경/취소")
        print("입력 : ")
        var menu = readLine()!!.toInt()

        when (menu) {
            1 -> {
                reserve.reserve()
            }

            2 -> {

            }

            3 -> {

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

    var today: String = "20230720"
    var myList: List[]
    fun reserve() {
        println("예약자분의 성함을 입력해주세요")
        var name = readLine()!!.toString()
        println("예약할 방번호를 입력해주세요")
        var room = readLine()!!.toString()
        println("체크인 날짜를 입력해주세요")
        var checkIn = readLine()!!.toString()
        println("체크아웃 날짜를 입력해주세요")
        var checkOut = readLine()!!.toString()
//        roomPerson.put(room,name)
//        roomCheckIn.put(room,checkIn)
//        roomCheckOut.put(room,checkOut)
        myList[0] = name
        println("호텔 예약이 완료되었습니다.")

    }
}

class Check() {
    fun check() {

    }
}

class Check_ASC() {
    fun check() {

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
