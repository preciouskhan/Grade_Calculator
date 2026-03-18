package com.example.grade_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    private val courses = mutableListOf<Course>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etName = findViewById<EditText>(R.id.etName)
        val etId = findViewById<EditText>(R.id.etId)
        val etCourseName = findViewById<EditText>(R.id.etCourseName)
        val etCA = findViewById<EditText>(R.id.etCA)
        val etExam = findViewById<EditText>(R.id.etExam)
        val tvCourseCount = findViewById<TextView>(R.id.tvCourseCount)
        val btnAddCourse = findViewById<Button>(R.id.btnAddCourse)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnAddCourse.setOnClickListener {
            if (courses.size >= 6) {
                Toast.makeText(this, "Maximum 6 courses allowed", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val courseName = etCourseName.text.toString().trim()
            val ca = etCA.text.toString().toIntOrNull()
            val exam = etExam.text.toString().toIntOrNull()

            if (courseName.isEmpty() || ca == null || exam == null) {
                Toast.makeText(this, "Enter valid course data", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (ca !in 0..100 || exam !in 0..100) {
                Toast.makeText(this, "Marks must be between 0 and 100", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            courses.add(Course(courseName, ca, exam))
            tvCourseCount.text = "Courses added: ${courses.size}/6"
            
            Toast.makeText(this, "$courseName added", Toast.LENGTH_SHORT).show()

            etCourseName.text.clear()
            etCA.text.clear()
            etExam.text.clear()
        }

        btnCalculate.setOnClickListener {
            val studentName = etName.text.toString().trim()
            val studentId = etId.text.toString().trim()

            if (studentName.isEmpty() || studentId.isEmpty()) {
                Toast.makeText(this, "Enter student name and ID", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (courses.isEmpty()) {
                Toast.makeText(this, "Add at least one course", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val resultText = StringBuilder()
            resultText.append("STUDENT REPORT\n")
            resultText.append("----------------------------\n")
            resultText.append("Name: $studentName\n")
            resultText.append("ID:   $studentId\n")
            resultText.append("----------------------------\n\n")

            var totalAverage = 0.0

            for (course in courses) {
                val average = (course.caMark + course.examMark) / 2
                totalAverage += average

                val grade = when (average) {
                    in 90..100 -> "A+"
                    in 80..89 -> "A"
                    in 70..79 -> "B+"
                    in 65..69 -> "B"
                    in 55..64 -> "C+"
                    in 50..54 -> "C"
                    in 45..49 -> "D+"
                    in 35..44 -> "D"
                    else -> "F"
                }

                resultText.append("${course.courseName.padEnd(15)} Avg: $average ($grade)\n")
            }

            val overallAvg = totalAverage / courses.size
            resultText.append("\n----------------------------\n")
            resultText.append("OVERALL AVERAGE: ${String.format("%.2f", overallAvg)}%\n")
            
            tvResult.text = resultText.toString()
        }
    }
}
