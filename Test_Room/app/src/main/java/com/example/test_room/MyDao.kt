package com.example.test_room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MyDAO {
    // 추가
    @Insert(onConflict = OnConflictStrategy.REPLACE)  // INSERT, key 충돌이 나면 새 데이터로 교체
    suspend fun insertStudent(student: Student)

    @Query("SELECT * FROM student_table")
    fun getAllStudents(): LiveData<List<Student>>        // LiveData<> 사용
    // 변동이 있을 때 마다 데이터 리턴

    // 이름으로 검색
    @Query("SELECT * FROM student_table WHERE name = :sname")   // 메소드 인자를 SQL문에서 :을 붙여 사용
    suspend fun getStudentByName(sname: String): List<Student>


    //삭제
    @Delete
    suspend fun deleteStudent(student: Student); // primary key is used to find the student

}