package com.example.assignment_login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignInActivity : AppCompatActivity() {
    val user = User()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        val signInBtn = findViewById<Button>(R.id.btn_sign_in)
        val signUpBtn = findViewById<Button>(R.id.btn_sign_up)
        val signInId = findViewById<EditText>(R.id.login_id)
        val signInPw = findViewById<EditText>(R.id.login_pw)


        signInBtn.setOnClickListener {
            if (signInId.text.isEmpty() || signInPw.text.isEmpty()) {
                Toast.makeText(this, "빈칸을 모두 채워주세요!", Toast.LENGTH_SHORT).show()
            }
            else {
                var isTrue = user.readUser(signInId.text.toString(), signInPw.text.toString())
                if (isTrue) {
                    Toast.makeText(this, "환영합니다!", Toast.LENGTH_SHORT).show()
                    val intent1 = Intent(this, HomeActivity::class.java)
                    startActivity(intent1)
                }
                else
                {
                    Toast.makeText(this, "ID와 PW를 한번 더 확인해주세요 :)", Toast.LENGTH_SHORT).show()
                }
            }

        }
        signUpBtn.setOnClickListener {
            val intent2 = Intent(this, SignUpActivity::class.java)
            startActivity(intent2)
        }


    }

}