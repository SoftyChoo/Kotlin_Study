package com.example.assignment_login

import android.widget.Toast

class User {
    val userArray = Array(10) { Array<String?>(3) { null} } //10행 5열짜리 2차원 배열 선언 + null로 초기화

    fun addUser(name: String, id: String, pw: String) {
        for(i in 0..9)
        {
            if(userArray[i][0] == null)
            {
                userArray[i][0] = name
                userArray[i][1] = id
                userArray[i][2] = pw
                break
            }
        }
    }
    fun readUser(signInId: String, signInPw: String): Boolean {
        for(i in 0..9)
        {
            if(userArray[i][1] == signInId)
            {
                if(userArray[i][2] == signInPw)
                {
                    return true
                }
                else{
                    Toast.makeText(SignInActivity(),"PW를 확인해주세요!",Toast.LENGTH_SHORT).show()
                }
            }
            else
            {
                return false
            }
        }
        return true
    }
}