package com.example.kttest

fun main() {
    var accessTestClass = AccessTestClass()
    var accessTestChildClass = AccessTestChildClass()

// . 하고 접근가능한 요소를 확인
//    accessTestClass.
    accessTestChildClass.protectedTest1()
}