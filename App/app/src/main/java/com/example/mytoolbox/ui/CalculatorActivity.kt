package com.example.mytoolbox.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.mytoolbox.MainActivity
import com.example.mytoolbox.R
import kotlin.properties.Delegates

class CalculatorActivity : AppCompatActivity() {

    lateinit var textViewScreen: TextView
    lateinit var textViewResults: TextView
    lateinit var resultString: String
    var calculatingint = 0

    var firstInt = 0

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

        resultString = ""

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
        val devideButton = findViewById<Button>(R.id.cal_Button_Divide)
        val equalsButton = findViewById<Button>(R.id.cal_Button_equals)

        //number buttons onclicks
        button0.setOnClickListener {
            inputList.add("0")
            resultString += "0"
            updatetextViewScreen()
        }
        button1.setOnClickListener {
            inputList.add("1")
            resultString += "1"
            updatetextViewScreen()
        }
        button2.setOnClickListener {
            inputList.add("2")
            resultString += "2"
            updatetextViewScreen()
        }
        button3.setOnClickListener {
            inputList.add("3")
            resultString += "3"
            updatetextViewScreen()
        }
        button4.setOnClickListener {
            inputList.add("4")
            resultString += "4"
            updatetextViewScreen()
        }
        button5.setOnClickListener {
            inputList.add("5")
            resultString += "5"
            updatetextViewScreen()
        }
        button6.setOnClickListener {
            inputList.add("6")
            resultString += "6"
            updatetextViewScreen()
        }
        button7.setOnClickListener {
            inputList.add("7")
            resultString += "7"
            updatetextViewScreen()
        }
        button8.setOnClickListener {
            inputList.add("8")
            resultString += "8"
            updatetextViewScreen()
        }
        button9.setOnClickListener {
            inputList.add("9")
            resultString += "9"
            updatetextViewScreen()
        }


        //function buttons listeners
        clearButton.setOnClickListener {
            inputList.clear()
            resultString = ""
            calculatingint = 0
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
                resultString += "."
                updatetextViewScreen()
            }
        }
        plusButton.setOnClickListener {
            if(inputList.last() != "+"){
                inputList.add("+")
            }
            updatetextViewScreen()
            saveFirstInts()
        }
        minusButton.setOnClickListener {
            if(inputList.last() != "-"){
                inputList.add("-")
            }
            updatetextViewScreen()
            saveFirstInts()
        }
        timesButton.setOnClickListener {
            if(inputList.last() != "x"){
                inputList.add("x")
            }
            updatetextViewScreen()
            saveFirstInts()
        }
        devideButton.setOnClickListener {
            if(inputList.last() != "/"){
                inputList.add("/")
            }
            updatetextViewScreen()
            saveFirstInts()
        }
        equalsButton.setOnClickListener {
            if (resultString.isNotEmpty()) {
                calculatingint = resultString.toInt()
                if (inputList.contains("+")) {
                    resultString = firstInt.plus(calculatingint).toString()
                } else if (inputList.contains("-")) {
                    resultString = firstInt.minus(calculatingint).toString()
                } else if (inputList.contains("/")) {
                    resultString = firstInt.div(calculatingint).toString()
                } else if (inputList.contains("x")) {
                    resultString = firstInt.times(calculatingint).toString()
                }
                textViewResults.text = resultString
                inputList.clear()
                inputList.add(resultString)
            }
        }

    }

    fun updatetextViewScreen(){
        textViewScreen.text = inputList.joinToString (separator = "")
    }
    fun updatetextViewResults(){
        textViewResults.text = calculatingint.toString()
    }

    fun saveFirstInts(){
        firstInt = resultString.toInt()
        resultString = ""
    }
}