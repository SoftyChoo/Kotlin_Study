package com.example.test_room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.roomexample.MyDatabase
import com.example.test_room.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var myDao: MyDAO
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myDao = MyDatabase.getDatabase(this).getMyDao() //인스턴스 받아오기


        val allStudents = myDao.getAllStudents()

        // studentList에 변화가 있을 때 마다 호출돼 모든 학생을 화면에 추가
        allStudents.observe(this) {
            val str = StringBuilder().apply {
                for ((id, name) in it) {
                    append(id)
                    append("-")
                    append(name)
                    append("\n")
                }
            }.toString()
            binding.textStudentList.text = str
        }


        binding.addStudent.setOnClickListener { // id, name을 읽어와 비어있지 않으면 insert
            val id = binding.editStudentId.text.toString().toInt()
            val name = binding.editStudentName.text.toString()
            if (id > 0 && name.isNotEmpty()) {
                CoroutineScope(Dispatchers.IO).launch {
                    myDao.insertStudent(Student(id, name))
                }
            }
            //insert 이후 editText를 지워줌
            binding.editStudentId.text = null
            binding.editStudentName.text = null
        }

        binding.queryStudent.setOnClickListener { // name을 받아와 검색한 이후 일치하는 데이터 반환 //List로 받는 이유는 여러명일 가능성이 있어서
            val name = binding.editStudentName.text.toString()
            CoroutineScope(Dispatchers.IO).launch {

                val results = myDao.getStudentByName(name)

                if (results.isNotEmpty()) {
                    val str = StringBuilder().apply {
                        results.forEach { student ->
                            append(student.id)
                            append("-")
                            append(student.name)
                        }
                    }
                    withContext(Dispatchers.Main) { // Coroutine쓰레드 안에서 동작하는 것이기 때문에 UI를 업데이트 시켜주는 코드를 추가
                        binding.textQueryStudent.text = str
                    }
                } else {
                    withContext(Dispatchers.Main) { // Coroutine쓰레드 안에서 동작하는 것이기 때문에 UI를 업데이트 시켜주는 코드를 추가
                        binding.textQueryStudent.text = ""
                    }
                }
            }
        }
    }
}