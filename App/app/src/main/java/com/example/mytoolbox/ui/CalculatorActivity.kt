package com.example.mytoolbox.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.mytoolbox.MainActivity
import com.example.mytoolbox.R

class CalculatorActivity : AppCompatActivity() {

    lateinit var textViewScreen: TextView
    lateinit var textViewResults: TextView
    lateinit var lastUserString: String
    var calculatingDouble: Double = 0.0

    var firstDouble = 0.0

    val inputList = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        val backbutton = findViewById<Button>(R.id.calbackButton)

        textViewScreen = findViewById(R.id.calculatorScreen)
        textViewResults = findViewById(R.id.calculatorResult)

        backbutton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            this.startActivity(intent)
        }

        lastUserString = ""

        //number buttons
        val button0 = findViewById<Button>(R.id.cal_Button_0)
        val button1 = findViewById<Button>(R.id.cal_Button_1)
        val button2 = findViewById<Button>(R.id.cal_Button_2)
        val button3 = findViewById<Button>(R.id.cal_Button_3)
        val button4 = findViewById<Button>(R.id.cal_Button_4)
        val button5 = findViewById<Button>(R.id.cal_Button_5)
        val button6 = findViewById<Button>(R.id.cal_Button_6)
        val button7 = findViewById<Button>(R.id.cal_Button_7)
        val button8 = findViewById<Button>(R.id.cal_Button_8)
        val button9 = findViewById<Button>(R.id.cal_Button_9)

        val clearButton = findViewById<Button>(R.id.cal_Button_clear)
        val removeLastButton = findViewById<Button>(R.id.cal_Button_removeLast)

        val commaButton = findViewById<Button>(R.id.cal_Button_dot)
        val plusButton = findViewById<Button>(R.id.cal_Button_plus)
        val minusButton = findViewById<Button>(R.id.cal_Button_minus)
        val timesButton = findViewById<Button>(R.id.cal_Button_x)
        val divideButton = findViewById<Button>(R.id.cal_Button_Divide)
        val equalsButton = findViewById<Button>(R.id.cal_Button_equals)
        val taxButton = findViewById<Button>(R.id.cal_Button_tax)

        updatetextViewResults()

        //number buttons onclicks
        button0.setOnClickListener {
            inputList.add("0")
            lastUserString += "0"
            updatetextViewScreen()
        }
        button1.setOnClickListener {
            inputList.add("1")
            lastUserString += "1"
            updatetextViewScreen()
        }
        button2.setOnClickListener {
            inputList.add("2")
            lastUserString += "2"
            updatetextViewScreen()
        }
        button3.setOnClickListener {
            inputList.add("3")
            lastUserString += "3"
            updatetextViewScreen()
        }
        button4.setOnClickListener {
            inputList.add("4")
            lastUserString += "4"
            updatetextViewScreen()
        }
        button5.setOnClickListener {
            inputList.add("5")
            lastUserString += "5"
            updatetextViewScreen()
        }
        button6.setOnClickListener {
            inputList.add("6")
            lastUserString += "6"
            updatetextViewScreen()
        }
        button7.setOnClickListener {
            inputList.add("7")
            lastUserString += "7"
            updatetextViewScreen()
        }
        button8.setOnClickListener {
            inputList.add("8")
            lastUserString += "8"
            updatetextViewScreen()
        }
        button9.setOnClickListener {
            inputList.add("9")
            lastUserString += "9"
            updatetextViewScreen()
        }


        //function buttons listeners
        clearButton.setOnClickListener {
            inputList.clear()
            lastUserString = ""
            calculatingDouble = 0.0
            updatetextViewScreen()
            updatetextViewResults()
        }
        removeLastButton.setOnClickListener {
            if(inputList.isNotEmpty()) {
                inputList.removeLast()
                updatetextViewScreen()
            }
        }
        commaButton.setOnClickListener {
            if(!inputList.contains(".")){
                inputList.add(".")
                lastUserString += "."
                updatetextViewScreen()
            }
        }
        plusButton.setOnClickListener {
            if(inputList.last() != "+"){
                inputList.add("+")
                saveFirstInts()
            }
            updatetextViewScreen()

        }
        minusButton.setOnClickListener {
            if(inputList.last() != "-"){
                inputList.add("-")
                saveFirstInts()
            }
            updatetextViewScreen()

        }
        timesButton.setOnClickListener {
            if(inputList.last() != "x"){
                inputList.add("x")
                saveFirstInts()
            }
            updatetextViewScreen()

        }
        divideButton.setOnClickListener {
            if(inputList.last() != "/"){
                inputList.add("/")
                saveFirstInts()
            }
            updatetextViewScreen()

        }
        equalsButton.setOnClickListener {
            if (lastUserString.isNotEmpty()) {
                calculatingDouble = lastUserString.toDouble()
                var result = ""
                if (inputList.contains("+")) {
                    result = firstDouble.plus(calculatingDouble).toString()
                } else if (inputList.contains("-")) {
                    result = firstDouble.minus(calculatingDouble).toString()
                } else if (inputList.contains("/")) {
                    result = firstDouble.div(calculatingDouble).toString()
                } else if (inputList.contains("x")) {
                    result = firstDouble.times(calculatingDouble).toString()
                }
                textViewResults.text = result
                lastUserString = result
                inputList.clear()
                inputList.add(result)
            }
        }
        taxButton.setOnClickListener {
            if(lastUserString.isNotEmpty()){
                val calculateDouble = lastUserString.toDouble()
                var result = ""
                result = calculateDouble.times(1.21).toString()
                textViewResults.text = result
                lastUserString = result
                inputList.clear()
                inputList.add(result)
            }
        }

    }

    fun updatetextViewScreen(){
        textViewScreen.text = inputList.joinToString (separator = "")
    }
    fun updatetextViewResults(){
        textViewResults.text = calculatingDouble.toString()
    }

    fun saveFirstInts(){
        firstDouble = lastUserString.toDouble()
        lastUserString = ""
    }
}