package com.example.mytoolbox.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.mytoolbox.MainActivity
import com.example.mytoolbox.R

class HeadsOrTailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heads_or_tails)


        val backButton = findViewById<Button>(R.id.hodbackButton)
        val headsOrTailsButton = findViewById<Button>(R.id.TossCoin)
        val textViewResult = findViewById<TextView>(R.id.headsOrTailsResult)

        backButton.setOnClickListener{
            val intent = Intent (this, MainActivity::class.java)
            this.startActivity(intent)
        }

        headsOrTailsButton.setOnClickListener{
            val headsOrTailsResultString = when ((1..2).random()) {
                1 -> "Heads"
                2 -> "Tails"
                else -> {
                    "Error, Please retry"
                }
            }
            textViewResult.text = headsOrTailsResultString
        }
    }
}