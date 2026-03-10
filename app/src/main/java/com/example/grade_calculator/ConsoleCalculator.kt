package com.example.grade_calculator

fun main() {

    println("=== Student Grade Calculator ===")

    print("Enter student name: ")
    val name = readLine() ?: "Unknown"

    print("Enter student ID: ")
    val id = readLine() ?: "0000"

    val courses = mutableListOf<Course>()

    for (i in 1..6) {

        println("\nCourse $i")

        print("Course name: ")
        val courseName = readLine() ?: "Unknown"

        print("CA mark (leave empty if none): ")
        val caInput = readLine()
        val caMark = caInput?.toIntOrNull()

        print("Exam mark (leave empty if none): ")
        val examInput = readLine()
        val examMark = examInput?.toIntOrNull()

        courses.add(Course(courseName, caMark, examMark))
    }

    val student = Student(name, id, courses)

    println("\n--- Results ---")
    println("Student: ${student.name}")
    println("ID: ${student.id}")

    for (course in student.courses) {

        if (course.caMark == null || course.examMark == null) {
            println("${course.courseName}: Incomplete")
        } else {

            val average = (course.caMark + course.examMark) / 2

            val grade = when (average) {
                in 0..34 -> "F"
                in 35..44 -> "D"
                in 45..49 -> "D+"
                in 50..54 -> "C"
                in 55..64 -> "C+"
                in 65..69 -> "B"
                in 70..79 -> "B+"
                in 80..89 -> "A"
                in 90..100 -> "A+"
                else -> "Invalid"
            }

            println("${course.courseName}: Average = $average | Grade = $grade")
        }
    }
}