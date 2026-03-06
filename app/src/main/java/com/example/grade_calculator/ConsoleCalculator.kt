package com.example.grade_calculator

fun main() {

    println("===== Student Grade Calculator =====")

    print("Enter Student Name: ")
    val name = readLine() ?: "Unknown"

    print("Enter Student ID: ")
    val id = readLine() ?: "0000"

    val courses = mutableListOf<Course>()

    val maxCourses = 6

    for (i in 1..maxCourses) {

        println("\nEnter details for Course $i")

        print("Course Name (or press Enter to stop): ")
        val nameInput = readLine()

        if (nameInput.isNullOrBlank()) {
            break
        }

        print("CA Mark (press Enter if missing): ")
        val caInput = readLine()
        val ca = caInput?.toIntOrNull()

        print("Exam Mark (press Enter if missing): ")
        val examInput = readLine()
        val exam = examInput?.toIntOrNull()

        val course = Course(
            name = nameInput,
            ca = ca,
            exam = exam
        )
        courses.add(course)
    }

    val student = Student(
        name = name,
        id = id,
        courses = courses
    )

    println("\n===== RESULTS =====")
    println("Student: ${student.name}")
    println("ID: ${student.id}")

    val calculateAverage: (Int, Int) -> Double = { ca, exam ->
        (ca + exam) / 2.0
    }

    val gradeFunction: (Double) -> String = { score ->
        when (score.toInt()) {
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
    }

    val processCourse: (Course) -> Unit = { course ->
        if (course.ca == null || course.exam == null) {
            println("${course.name} : Incomplete")
        } else {
            val avg = calculateAverage(course.ca, course.exam)
            val grade = gradeFunction(avg)
            println("${course.name} : Average = $avg Grade = $grade")
        }
    }

    courses.forEach(processCourse)

    println("\n===== END =====")
}