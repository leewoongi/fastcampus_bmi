package com.wg.bmi

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class ResultActivity: AppCompatActivity() {

    private val tag: String = "ResultActivity"
    private lateinit var bmiValueTextView: TextView
    private lateinit var resultBmiTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        initialize()

        val height: Int = intent.getIntExtra("height", 0)
        val weight: Int = intent.getIntExtra("weight", 0)

        Log.d(tag, "height : $height , weight : $weight")

        val bmi = calculateBmi(height, weight)
        val resultText = when{
            bmi >= 35.0 ->"고도 비만"
            bmi >= 30.0 ->"중정도 비만"
            bmi >= 25.0 ->"경도 비만"
            bmi >= 23.0 ->"과체중"
            bmi >= 18.5 ->"정상체중"
            else ->"저체중"
        }

        bmiValueTextView.text = bmi.toString()
        resultBmiTextView.text = resultText

    }

    private fun initialize() {
        bmiValueTextView = findViewById(R.id.tv_bmi_value)
        resultBmiTextView = findViewById(R.id.tv_bmi_result)
    }

    private fun calculateBmi(height: Int, weight: Int): Double {
        return weight / (height / 100.0).pow(2.0)
    }
}