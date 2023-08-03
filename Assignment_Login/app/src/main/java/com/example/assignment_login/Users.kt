package com.example.assignment_login

object Users {
    //val userArray = Array(10) { Array<String?>(3) { null } } //10행 5열짜리 2차원 배열 선언 + null로 초기화
    var array = mutableListOf<User>()

    fun addUser(name: String, id: String, pw: String, age: String, mbti: String) {
        val user2 = User(name = name, id = id, pw = pw ,age = age, mbti = mbti)
        array.add(user2)
    }

    fun readUser(signInId: String, signInPw: String): User? {
        for (user in array) {
            if (signInId == user.id && signInPw == user.pw) {
                return user
            } else {
                continue
            }
        }
        return null
    }
}