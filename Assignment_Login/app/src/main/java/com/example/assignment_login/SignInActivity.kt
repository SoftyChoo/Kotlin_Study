package com.example.assignment_login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignInActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        val signInBtn = findViewById<Button>(R.id.btn_sign_in)
        val signUpBtn = findViewById<Button>(R.id.btn_sign_up)
        val signInId = findViewById<EditText>(R.id.login_id)
        val signInPw = findViewById<EditText>(R.id.login_pw)

        val inputId = intent.getStringExtra("input_id")
        val inputPw = intent.getStringExtra("input_pw")
        signInId.setText(inputId)
        signInPw.setText(inputPw)

        signInBtn.setOnClickListener {
            if (signInId.text.isEmpty() || signInPw.text.isEmpty()) {
                Toast.makeText(this, "빈칸을 모두 채워주세요!", Toast.LENGTH_SHORT).show()
            }
            else {
                val user = Users.readUser(signInId.text.toString(), signInPw.text.toString())
                if(user == null)
                {
                    Toast.makeText(this, "ID와 PW를 한번 더 확인해주세요 :)", Toast.LENGTH_SHORT).show()
                }
                else {
                    val intentToHome = Intent(this, HomeActivity::class.java)
                    intentToHome.putExtra("user_name",user.name)
                    intentToHome.putExtra("user_id",user.id)
                    intentToHome.putExtra("user_age",user.age)
                    intentToHome.putExtra("user_mbti",user.mbti)
                    startActivity(intentToHome)
                }
            }
        }
        signUpBtn.setOnClickListener {
            val intentToSignUp = Intent(this, SignUpActivity::class.java)
            startActivity(intentToSignUp)
        }
    }

}