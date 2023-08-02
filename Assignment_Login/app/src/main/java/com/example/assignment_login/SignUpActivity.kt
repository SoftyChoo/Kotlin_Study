package com.example.assignment_login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {

    var user = User()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val editBtn = findViewById<Button>(R.id.btn_edit)

        val name = findViewById<EditText>(R.id.edit_name)
        val id = findViewById<EditText>(R.id.edit_id)
        val pw = findViewById<EditText>(R.id.edit_pw)

        editBtn.setOnClickListener {
            if (name.text.isEmpty() || id.text.isEmpty() || pw.text.isEmpty()) {
                Toast.makeText(this, "빈칸을 모두 채워주세요!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "정보가 정상적으로 저장되었습니다.", Toast.LENGTH_SHORT).show()
                user.addUser(name.text.toString(), id.text.toString(),pw.text.toString())
                finish()
            }
        }
    }
}