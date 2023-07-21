package com.example.myhotel

class Change() {

    fun change(array: Array<Array<String?>>) {
        val thisArray = arrayOfNulls<Int>(900)
        var count = 0
        var change: Int

        println("예약을 변경할 사용자 이름을 입력하세요")
        var name = readLine()!!.toString()
        for (i in 0..899) {
            if (array[i][0] == name) {
                println(array[i][0] + "님이 예약한 목록입니다. 변경하실 방의 예약번호를 입력해주세요")
                break
            }
        }
        while (true) {
            for (i in 0..899) {
                if (array[i][0] == name) {
                    thisArray[count++] = i
                    println("${count}. 방번호: " + array[i][1] + ",체크인: " + array[i][2] + ",체크아웃: " + array[i][3])
                }
            }
            change = readLine()!!.toInt()
            if (thisArray[change] != null) break
            else println("범위에 없는 예약번호 입니다. 다시 입력해주세요")
        }
        while (true) {
            println("해당 예약 1.변경, 2.취소")
            var change2 = readLine()!!.toInt()
            when (change2) {
                1 -> break
                2 -> {
                    println("[취소 유의사항]")
                    println("체크인 3일 이전 취소 예약금 환불 불가")
                    println("체크인 5일 이전 취소 예약금의 30% 환불")
                    println("체크인 7일 이전 취소 예약금의 50% 환불")
                    println("체크인 14일 이전 취소 예약금의 80% 환불")
                    println("체크인 30일 이전 취소 예약금의 100% 환불")

                    array[thisArray[change]!!][0] = null
                    array[thisArray[change]!!][1] = null
                    array[thisArray[change]!!][2] = null
                    array[thisArray[change]!!][3] = null
                    array[thisArray[change]!!][4] = null
                    array[thisArray[change]!!][5] = null

                    println("취소가 완료되었습니다.")
                    break
                }

                else -> println("범위에 없는 번호 입니다. 다시 입력해주세요")
            }
        }
    }
}