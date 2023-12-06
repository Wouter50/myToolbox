package com.example.mytoolbox.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextSwitcher
import android.widget.TextView
import android.widget.ViewSwitcher
import androidx.appcompat.app.AppCompatActivity
import com.example.mytoolbox.MainActivity
import com.example.mytoolbox.R


class HeadsOrTailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heads_or_tails)


        val backButton = findViewById<Button>(R.id.hodbackButton)
        val headsOrTailsButton = findViewById<Button>(R.id.TossCoin)
        var textViewResult = findViewById<TextSwitcher>(R.id.headsOrTailsResult)
        textViewResult.setFactory { TextView(this) }

        textViewResult.setInAnimation(this, android.R.anim.slide_in_left)
        textViewResult.setOutAnimation(this, android.R.anim.slide_out_right)


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
            textViewResult.setText(headsOrTailsResultString)
        }
    }
}