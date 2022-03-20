package com.wg.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var tallEditText: EditText
    lateinit var weightEditText: EditText
    lateinit var confirmButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialize()

    }

    private fun initialize() {
        tallEditText = findViewById(R.id.et_tall)
        weightEditText = findViewById(R.id.et_weight)
        confirmButton = findViewById(R.id.bt_confirm)
    }
}