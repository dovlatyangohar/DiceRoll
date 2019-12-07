package com.example.diceroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var diceImage1: ImageView
    private var resultText: String = ""
    private lateinit var diceValue: TextView
    private lateinit var firstValue: TextView
    private lateinit var secondValue: TextView
    lateinit var lastValue: TextView
    private val arrayOfValues = arrayOf("", "", "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImage1 = findViewById(R.id.dice_image)
        firstValue = findViewById(R.id.first_value)
        secondValue = findViewById(R.id.second_value)
        lastValue = findViewById(R.id.last_value)


        val rollButton: Button = findViewById(R.id.roll_btn)
        rollButton.setOnClickListener {
            rollDice()
            updateValues(resultText)
        }

        val showValues: Button = findViewById(R.id.show_btn)
        showValues.setOnClickListener {
            getValues()
        }

    }

    private fun rollDice() {
        diceImage1.setImageResource(getRandomDiceImage())
        diceValue = findViewById(R.id.dice_value)
        diceValue.text = resultText

    }

    private fun getRandomDiceImage(): Int {
        val result = Random().nextInt(6) + 1
        resultText = result.toString()
        return when (result) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }

    private fun getValues() {
        firstValue.text = arrayOfValues[0]
        secondValue.text = arrayOfValues[1]
        lastValue.text = arrayOfValues[2]

    }

    private fun updateValues(dValue: String): Array<String> {
        arrayOfValues[0] = arrayOfValues[1]
        arrayOfValues[1] = arrayOfValues[2]
        arrayOfValues[2] = dValue
        return arrayOfValues
    }

}
