package com.example.myhotel

import java.util.Random

fun main() {

    var reserve = Reservation()
    var check = Check()
    var check_asc = Check_ASC()
    var account = Account()
    var change = Change()
    // 4x900 2차원 배열 선언
    var array = Array(900) { arrayOfNulls<String>(6) }
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
            }

            2 -> {
                check.check(array)
            }

            3 -> {
                check_asc.check_asc(array)
            }

            4 -> {
                print("시스템을 종료합니다.")
                return
            }

            5 -> {
                account.account(array)
            }

            6 -> {
                change.change(array)
            }

            else -> println("올바르지 않은 값을 입력하였습니다. 다시 입력해주세요!")
        }
    }
}











