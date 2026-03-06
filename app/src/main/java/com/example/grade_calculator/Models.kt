package com.example.grade_calculator

data class Course(
    val name: String,
    val ca: Int?,
    val exam: Int?
)

data class Student(
    val name: String,
    val id: String,
    val courses: MutableList<Course>
)