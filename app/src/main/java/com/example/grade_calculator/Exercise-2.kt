package com.example.grade_calculator

// Higher-Order Function: processes a single grade
fun processGrade(grade: Int, modifier: (Int) -> Int): Int {
    return modifier(grade)
}

// Student class for OOP example
data class ExerciseStudent(val id: Int, val name: String, val grades: List<Int>) {
    fun average() = grades.average()
}

fun main() {
    println("Exercise 2: Chapter 2 console tests")

    // Higher-Order Function example
    val originalGrade = 75
    val updatedGrade = processGrade(originalGrade) { it + 5 }
    println("Original Grade: $originalGrade, Updated Grade: $updatedGrade\n")

    // Lambda function with lists
    val grades = listOf(60, 70, 85, 90)
    val curvedGrades = grades.map { it + 5 }
    println("Original Grades: $grades")
    println("Curved Grades (+5): $curvedGrades")
    val passingGrades = grades.filter { it >= 50 }
    println("Passing Grades: $passingGrades\n")

    // OOP example with Student list
    val students = listOf(
        ExerciseStudent(1, "Alice", listOf(60, 70, 80)),
        ExerciseStudent(2, "Bob", listOf(50, 65, 75)),
        ExerciseStudent(3, "Charlie", listOf(90, 85, 92))
    )

    students.forEach { println("${it.name}'s average: ${it.average()}") }

    // Curve student averages by +5
    val curvedAverages = students.map { it.average() + 5 }
    println("\nCurved Student Averages (+5): $curvedAverages")
}