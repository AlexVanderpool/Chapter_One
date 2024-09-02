package com.example.chapter_one

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var trueButton: Button
    private lateinit var falseButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trueButton = findViewById(R.id.True)
        falseButton = findViewById(R.id.False)


        trueButton.setOnClickListener { Toast.makeText(this,R.string.Correct, Toast.LENGTH_LONG).show() }
        falseButton.setOnClickListener { Toast.makeText(this,R.string.Incorrect, Toast.LENGTH_LONG).show() }

    }
}