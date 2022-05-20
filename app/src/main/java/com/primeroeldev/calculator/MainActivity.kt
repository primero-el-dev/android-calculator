package com.primeroeldev.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity()
{
    private var calculator: Calculator = Calculator()
    private var display: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?): Unit
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        display = findViewById(R.id.display)
        display?.setText(calculator.getCurrentNumber())

        initNumberButton(findViewById(R.id.button0), "0")
        initNumberButton(findViewById(R.id.button1), "1")
        initNumberButton(findViewById(R.id.button2), "2")
        initNumberButton(findViewById(R.id.button3), "3")
        initNumberButton(findViewById(R.id.button4), "4")
        initNumberButton(findViewById(R.id.button5), "5")
        initNumberButton(findViewById(R.id.button6), "6")
        initNumberButton(findViewById(R.id.button7), "7")
        initNumberButton(findViewById(R.id.button8), "8")
        initNumberButton(findViewById(R.id.button9), "9")
        initDotButton(findViewById(R.id.buttonDot))
        initActionButton(findViewById(R.id.buttonPlus)) { a, b -> a + b }
        initActionButton(findViewById(R.id.buttonMinus)) { a, b -> a - b }
        initActionButton(findViewById(R.id.buttonMultiply)) { a, b -> a * b }
        initActionButton(findViewById(R.id.buttonDivide)) { a, b -> a / b }
        initActionButton(findViewById(R.id.buttonModulo)) { a, b -> a % b }
        initClearButton(findViewById(R.id.buttonClear))
        initClearAllButton(findViewById(R.id.buttonClearAll))
        initEqualsButton(findViewById(R.id.buttonEquals))
    }

    private fun initNumberButton(button: Button, digit: String): Unit
    {
        button.setOnClickListener {
            calculator.appendNumber(digit)
            display?.setText(calculator.getCurrentNumber())
        }
    }

    private fun initDotButton(button: Button): Unit
    {
        button.setOnClickListener {
            calculator.appendDot()
            display?.setText(calculator.getCurrentNumber())
        }
    }

    private fun initActionButton(button: Button, action: (Double, Double) -> Double): Unit
    {
        button.setOnClickListener {
            calculator.doArithmeticAction(action)
            display?.setText(calculator.getCurrentNumber())
        }
    }

    private fun initClearButton(button: Button): Unit
    {
        button.setOnClickListener {
            calculator.clear()
            display?.setText(calculator.getCurrentNumber())
        }
    }

    private fun initClearAllButton(button: Button): Unit
    {
        button.setOnClickListener {
            calculator.clearAll()
            display?.setText(calculator.getCurrentNumber())
        }
    }

    private fun initEqualsButton(button: Button): Unit
    {
        button.setOnClickListener {
            calculator.calculate()
            display?.setText(calculator.getCurrentNumber())
        }
    }
}