package com.example.firstappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val FUN_SUM = "Sum"
        val FUN_SUBTRACT = "Subtract"
        val FUN_MULTIPLY = "Multiply"
        val FUN_DIVIDE = "Divide"

        val firstValue = findViewById<TextInputEditText>(R.id.first_value)
        val secondValue = findViewById<TextInputEditText>(R.id.secound_value)
        val spinner_operations: Spinner = findViewById(R.id.spinner_operations)
        val textResult: TextView = findViewById(R.id.text_result)
        val buttonReset: Button = findViewById(R.id.button_reset)

        ArrayAdapter.createFromResource(this,
                R.array.math_operations_array,
                android.R.layout.simple_spinner_dropdown_item).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner_operations.adapter = adapter
        }

        val buttonCalculate: Button = findViewById(R.id.button_calculate)
        buttonCalculate.setOnClickListener {
            val operation = spinner_operations.getItemAtPosition(spinner_operations.selectedItemPosition).toString()

            when (operation) {
                FUN_SUM -> textResult.text = add(firstValue.text.toString().toDouble(),
                        secondValue.text.toString().toDouble())

                FUN_SUBTRACT -> textResult.text = subtract(firstValue.text.toString().toDouble(),
                        secondValue.text.toString().toDouble())


                FUN_MULTIPLY -> textResult.text = multiply(firstValue.text.toString().toDouble(),
                        secondValue.text.toString().toDouble())

                FUN_DIVIDE -> textResult.text = divide(firstValue.text.toString().toDouble(),
                        secondValue.text.toString().toDouble())

            }
            firstValue.visibility = View.GONE
            secondValue.visibility = View.GONE
            spinner_operations.visibility = View.GONE
            textResult.visibility = View.VISIBLE
            buttonCalculate.visibility = View.GONE
            buttonReset.visibility = View.VISIBLE
        }

        buttonReset.setOnClickListener {
            firstValue.visibility = View.VISIBLE
            secondValue.visibility = View.VISIBLE
            spinner_operations.visibility = View.VISIBLE
            textResult.visibility = View.GONE
            buttonReset.visibility = View.GONE
            buttonCalculate.visibility = View.VISIBLE
        }

    }

    private fun add(firstValue: Double, secoundValue: Double): String {
        return "${firstValue + secoundValue}"
    }

    private fun subtract(firstValue: Double, secoundValue: Double): String {
        return "${firstValue - secoundValue}"
    }

    private fun multiply(firstValue: Double, secoundValue: Double): String {
        return "${firstValue * secoundValue}"
    }

    private fun divide(firstValue: Double, secoundValue: Double): String {
        return "${firstValue / secoundValue}"
    }

}
