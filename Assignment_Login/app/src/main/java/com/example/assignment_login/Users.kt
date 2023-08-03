package com.example.assignment_login

object Users {
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