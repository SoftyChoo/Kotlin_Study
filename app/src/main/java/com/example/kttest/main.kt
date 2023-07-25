package com.example.kttest
fun main() {
    val orderList: MutableSet<String> = mutableSetOf()
    val bread = Bread()
    val snacks = Snacks()
    val cake = Cake()
    var menu = Menu()
    println("성심당에 오신것을 환영합니다.")

    while (true)
    {
        while (true) {
            println("주문하시겠습니까? [yes : 1] [no : 2] ")
            var n = readln()!!.toInt()
            when (n) {
                1 -> {
                    println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n")
                    println("[ 성심당 MENU ]")
                    println("1. Bread | 간단한 설명")
                    println("2. Snacks | 간단한 설명")
                    println("3. Cake | 간단한 설명")
                    break
                }
                2 -> {
                    println("키오스크를 종료합니다.")
                    return
                }
                else -> println("범위 밖의 값을 입력했습니다. 다시 입력해주세요")
            }
        }
        var n2 = readln()!!.toInt()
        var choice : String
        when(n2)
        {
            1 -> bread.add(orderList)
            2 -> snacks.add(orderList)
            3 -> cake.add(orderList)
            else -> println("예외처리")
        }
        println("장바구니에 추가되었습니다!")
        println("[더 주문하기 : 1] [결제 : 2]")
        var n3 = readln()!!.toInt()
        when(n3)
        {
            1 -> continue
            2 -> break
            else -> println("예외처리")
        }
    }
    println(orderList) //출력대신 Order class 호출 예정


}
open class Menu() {
    val breadArray = arrayOf( arrayOf("소보루빵", 1000), arrayOf("단팥빵", 2000 ),arrayOf("마늘빵", 3000),arrayOf("맘모스빵", 4000))
    val snacksArray = arrayOf( arrayOf("과자1", 1000), arrayOf("과자2", 2000 ),arrayOf("과자3", 3000),arrayOf("과자4", 4000))
    val cakeArray = arrayOf( arrayOf("케이크1", 1000), arrayOf("케이크2", 2000 ),arrayOf("케이크3", 3000),arrayOf("케이크4", 3000))
    open fun add(orderList: MutableSet<String>) {

    }
}

class Bread() : Menu() {
    override fun add(orderList: MutableSet<String>) {
        println("[ Bread MENU ]")
        println("1. 소보루빵 | 간단한 설명")
        println("2. 단팥빵 | 간단한 설명")
        println("3. 마늘빵 | 간단한 설명")
        println("4. 맘모스빵 | 간단한 설명")

        var choice = readln()!!.toInt()
        orderList.add(breadArray[choice-1][0].toString())

    }
}

class Snacks() : Menu() {
    override fun add(orderList: MutableSet<String>) {
        println("[ Snacks MENU ]")
        println("1. Snacks 1 | 간단한 설명")
        println("2. Snacks 2 | 간단한 설명")
        println("3. Snacks 3 | 간단한 설명")
        println("4. Snacks 4 | 간단한 설명")

        var choice = readln()!!.toInt()
        orderList.add(snacksArray[choice-1][0].toString())
    }
}

class Cake() : Menu() {
    override fun add(orderList: MutableSet<String>) {
        println("[ Cake MENU ]")
        println("1. Cake 1 | 간단한 설명")
        println("2. Cake 2 | 간단한 설명")
        println("3. Cake 3 | 간단한 설명")
        println("4. Cake 4 | 간단한 설명")

        var choice = readln()!!.toInt()
        orderList.add(cakeArray[choice-1][0].toString())
    }
}

class Order() : Menu() {
    override fun add(orderList: MutableSet<String>) {
        //장바구니의 빵 정보를 받아와서 출력 예정 + 총 계산금액
    }
}