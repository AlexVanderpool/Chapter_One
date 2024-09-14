package com.example.chapter_Two

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.example.chapter_Two.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var trueButton: Button
    private lateinit var falseButton: Button

    private lateinit var binding: ActivityMainBinding

    private val questionBank = listOf(
        Question(R.string.Question_Australia, true),
        Question(R.string.Question_oceans, true),
        Question(R.string.Question_mideast, false),
        Question(R.string.Question_africa, false),
        Question(R.string.Question_americas, true),
        Question(R.string.Question_asia, true)
    )

    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // trueButton = findViewById(R.id.True)
        // falseButton = findViewById(R.id.False)

        binding.True.setOnClickListener {
         /*   Toast.makeText(this, R.string.Correct, Toast.LENGTH_SHORT).show() */
            checkAnswer(true)
        }
        binding.False.setOnClickListener {
            /* Toast.makeText(
                this,
                R.string.Incorrect,
                Toast.LENGTH_SHORT
            ).show()
            */
            checkAnswer(false)
        }

        binding.nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            //val questionTextResId = questionBank[currentIndex].textResId
            //binding.questionTextView.setText(questionTextResId)
            updateQuestion()
        }

        // val questionTextResId = questionBank[currentIndex].textResId
        // binding.questionTextView.setText(questionTextResId)
        updateQuestion()
    }

    private fun updateQuestion() {
        val questionTextResId = questionBank[currentIndex].textResId
        binding.questionTextView.setText(questionTextResId)

    }

    private fun checkAnswer(userAnswer: Boolean) {
        var correctAnswer = questionBank[currentIndex].answer

        val messageResID = if (userAnswer == correctAnswer) {
            R.string.Correct
        } else {
            R.string.Incorrect
        }
    Toast.makeText( this,
        messageResID,
        Toast.LENGTH_SHORT).show()
    }
}