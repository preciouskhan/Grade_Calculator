package com.example.grade_calculator


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private val courses = mutableListOf<Course>()   // Store up to 6 courses

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etName = findViewById<EditText>(R.id.etName)
        val etId = findViewById<EditText>(R.id.etId)
        val etCourseName = findViewById<EditText>(R.id.etCourseName)
        val etCA = findViewById<EditText>(R.id.etCA)
        val etExam = findViewById<EditText>(R.id.etExam)
        val btnAddCourse = findViewById<Button>(R.id.btnAddCourse)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnAddCourse.setOnClickListener {

            if (courses.size >= 6) {
                Toast.makeText(this, "Maximum 6 courses allowed", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val courseName = etCourseName.text.toString()
            val ca = etCA.text.toString().toIntOrNull()
            val exam = etExam.text.toString().toIntOrNull()

            val course = Course(courseName, ca, exam)
            courses.add(course)

            Toast.makeText(this, "Course Added", Toast.LENGTH_SHORT).show()

            etCourseName.text.clear()
            etCA.text.clear()
            etExam.text.clear()
        }

        btnCalculate.setOnClickListener {

            val student = Student(
                name = etName.text.toString(),
                studentId = etId.text.toString(),
                courses = courses
            )

            val resultText = StringBuilder()
            resultText.append("Name: ${student.name}\n")
            resultText.append("ID: ${student.studentId}\n\n")

            for (course in student.courses) {

                resultText.append("Course: ${course.courseName}\n")

                if (course.caMark == null || course.examMark == null) {
                    resultText.append("Result: Incomplete\n\n")
                } else {

                    val average = (course.caMark!! + course.examMark!!) / 2

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

                    resultText.append("Average: $average\n")
                    resultText.append("Grade: $grade\n\n")
                }
            }

            tvResult.text = resultText.toString()
        }
    }
}