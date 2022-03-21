package com.wg.bmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val tag: String = "MainActivity"

    private lateinit var tallEditText: EditText
    private lateinit var weightEditText: EditText
    private lateinit var confirmButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialize()

        confirmButton.setOnClickListener {
            Log.d(tag, "Confirm Button click")

            if(isHeightEmpty() || isWeightEmpty()){
                Toast.makeText(this, "키와 몸무게 중 빈 값이 존재 합니다.", Toast.LENGTH_LONG).show()
                return@setOnClickListener;
            }

            // edittext에 빈값이 올 수 없음

            // 신장 입력 값 , 몸무게 입력 값 가져오기
            val height: Int = tallEditText.text.toString().toInt()
            val weight: Int = weightEditText.text.toString().toInt()
            Log.d(tag, "height : $height , weight : $weight")

            sendDataToResultActivity(height, weight)
        }

    }

    private fun initialize() {
        tallEditText = findViewById(R.id.et_height)
        weightEditText = findViewById(R.id.et_weight)
        confirmButton = findViewById(R.id.bt_confirm)
    }

    private fun isHeightEmpty(): Boolean {
        Log.d(tag, "isHeightEmpty")
        return tallEditText.text.isEmpty()
    }

    private fun isWeightEmpty(): Boolean {
        Log.d(tag, "isWeightEmpty")
        return weightEditText.text.isEmpty()
    }

    private fun sendDataToResultActivity(height: Int, weight: Int) {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("height", height)
        intent.putExtra("weight", weight)
        startActivity(intent)
    }
}