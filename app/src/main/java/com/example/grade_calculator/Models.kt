package com.example.grade_calculator

data class Course(
    val courseName: String,
    var caMark: Int?,      // Nullable
    var examMark: Int?     // Nullable
)

data class Student(
    val name: String,
    val studentId: String,
    val courses: MutableList<Course>
)