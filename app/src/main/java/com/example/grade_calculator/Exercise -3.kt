package com.example.grade_calculator

// Higher-Order Function: applies a function to a list of grades
fun applyToGrades(grades: List<Int>, operation: (Int) -> Int): List<Int> {
    return grades.map(operation)
}

// Course class for OOP example
data class ExerciseCourse(val id: Int, val name: String, val grades: List<Int>) {
    fun average() = grades.average()
}

fun main() {
    println("Exercise 3: Chapter 2 console tests")

    // Example: applying a curve to a list of grades
    val originalGrades = listOf(55, 65, 75, 85)
    val curvedGrades = applyToGrades(originalGrades) { it + 10 }
    println("Original Grades: $originalGrades")
    println("Curved Grades (+10): $curvedGrades\n")

    // Filter passing grades
    val passingGrades = originalGrades.filter { it >= 50 }
    println("Passing Grades: $passingGrades\n")

    // OOP example: courses
    val courses = listOf(
        ExerciseCourse(1, "Math", listOf(60, 70, 80)),
        ExerciseCourse(2, "Physics", listOf(50, 65, 75)),
        ExerciseCourse(3, "Chemistry", listOf(90, 85, 92))
    )

    courses.forEach { println("${it.name} average: ${it.average()}") }

    // Curve all course averages by +5
    val curvedCourseAverages = courses.map { it.average() + 5 }
    println("\nCurved Course Averages (+5): $curvedCourseAverages")
}