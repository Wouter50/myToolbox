package com.example.mytoolbox.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.mytoolbox.MainActivity
import com.example.mytoolbox.R

class RandomNumberActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_number)


        val backButton = findViewById<Button>(R.id.rngbackButton)
        val giveNumber = findViewById<Button>(R.id.giveNumber)
        val resultView = findViewById<TextView>(R.id.resultView)

        val startNumber = findViewById<EditText>(R.id.startNumber)
        val endNumber = findViewById<EditText>(R.id.endNumber)

        backButton.setOnClickListener{
            val intent = Intent (this, MainActivity::class.java)
            this.startActivity(intent)
        }

        giveNumber.setOnClickListener{      //crashes when crosses max length of int
            val startNumberInt = Integer.parseInt(startNumber.text.toString())
            val endNumberInt = Integer.parseInt(endNumber.text.toString())


            if (endNumberInt < startNumberInt){
                resultView.text = "Error: End number needs to be higher than start number"
            }  else {
                resultView.text = (startNumberInt..endNumberInt).random().toString()
            }


        }

    }
}


