package com.example.test_room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_table") // table이름
data class Student(
    @PrimaryKey @ColumnInfo(name = "student_id") // 컬럼명
    val id :Int,
    val name : String
)