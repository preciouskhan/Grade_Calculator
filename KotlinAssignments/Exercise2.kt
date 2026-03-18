data class Student(
    val name: String,
    val score: Int?
)

fun calculateGrade(score: Int): String {
    return when (score) {
        in 90..100 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        in 60..69 -> "D"
        else -> "F"
    }
}

fun main() {

    val students = listOf(
        Student("Alice", 95),
        Student("Bob", 82),
        Student("Charlie", null),
        Student("Diana", 67),
        Student("Eric", 45)
    )

    students.forEach { student ->

        student.score?.let {

            val grade = calculateGrade(it)

            println("${student.name} scored $it : Grade $grade")

        } ?: println("No score available for ${student.name}")
    }
}