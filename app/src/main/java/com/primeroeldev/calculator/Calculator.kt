package com.primeroeldev.calculator

class Calculator
{
    private var previousNumber: String? = null
    private var currentNumber: String = "0"
    private var currentOperation: ((Double, Double) -> Double)? = null
    private var displayedResult: Boolean = false

    public fun doArithmeticAction(operation: (Double, Double) -> Double): Unit
    {
        if (previousNumber !== null && currentOperation !== null) {
            this.calculate()
        } else {
            previousNumber = currentNumber
            currentNumber = "0"
        }
        currentOperation = operation
    }

    public fun appendNumber(number: String): Unit
    {
        if (currentNumber === null || currentNumber === "0" || displayedResult) {
            currentNumber = number
            displayedResult = false
        } else {
            currentNumber += number
        }
    }

    public fun appendDot(): Unit
    {
        if (!currentNumber?.contains('.')!!) {
            currentNumber += "."
        }
    }

    public fun clear(): Unit
    {
        currentNumber = "0"
    }

    public fun clearAll(): Unit
    {
        previousNumber = null
        currentNumber = "0"
        displayedResult = false
        currentOperation = null
    }

    public fun getCurrentNumber(): String?
    {
        return currentNumber
    }

    public fun calculate(): Unit
    {
        val temp: Double = currentOperation!!(previousNumber!!.toDouble(), currentNumber!!.toDouble())
        previousNumber = currentNumber
        currentNumber = temp.toString()
        displayedResult = true
    }
}