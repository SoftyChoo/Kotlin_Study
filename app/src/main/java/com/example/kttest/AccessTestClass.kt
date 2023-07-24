package com.example.kttest

open class AccessTestClass {
    public var a:Int = 1
    var b = 2
    private var c = 3
    internal var d = 4
    protected var e = 5

    public fun publicTest() {
        println("public 입니다")
    }

    fun publicTest2() {
        println("public 입니다")
    }

    private fun privateTest() {
        println("private 입니다")
    }

    internal fun internalTest() {
        println("internal 입니다")
    }

    protected fun protectedTest() {
        println("protected 입니다")
    }
}
