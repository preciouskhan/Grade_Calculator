package com.example.grade_calculator

data class Course(
    val courseName: String,
    val caMark: Int?,
    val examMark: Int?
)

data class Student(
    val name: String,
    val id: String,
    val courses: MutableList<Course>
)