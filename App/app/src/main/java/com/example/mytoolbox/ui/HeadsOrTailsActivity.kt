package com.example.mytoolbox.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mytoolbox.MainActivity
import com.example.mytoolbox.R


class HeadsOrTailsActivity : AppCompatActivity() {
    lateinit var coinImageView: ImageView
    lateinit var headsOrTailsButton: Button
    lateinit var amountHeadsTextView: TextView
    lateinit var amountTailsTextView: TextView

    var amountHeadsInt: Int = 0
    var amountTailsInt: Int = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heads_or_tails)

        amountHeadsTextView = findViewById(R.id.amountHeadsTextView)
        amountTailsTextView = findViewById(R.id.amountTailsTextView)


        val backButton = findViewById<Button>(R.id.hodbackButton)
        headsOrTailsButton = findViewById(R.id.TossCoin)

        coinImageView = findViewById(R.id.coinImageView)


        backButton.setOnClickListener{
            val intent = Intent (this, MainActivity::class.java)
            this.startActivity(intent)
        }

        headsOrTailsButton.setOnClickListener{
            val randomNumber = (1..2).random()

            if (randomNumber == 1){
                flipTheCoin(R.drawable.ic_coin_heads)
            } else {
                flipTheCoin(R.drawable.ic_coin_tails)
            }

        }

    }
    private fun flipTheCoin(imageId: Int){
        coinImageView.animate().apply {
            coinImageView.setImageResource(R.drawable.ic_coin_empty)
            duration = 1000
            rotationYBy(1800f)
            headsOrTailsButton.isClickable = false
        }.withEndAction {
            coinImageView.setImageResource(imageId)
            headsOrTailsButton.isClickable = true
            if(imageId == R.drawable.ic_coin_heads){
                updateCounter("heads")
            } else {
                updateCounter("tails")
            }
        }
    }
    private fun updateCounter(result: String){
        if (result == "heads"){
            amountHeadsInt++
            amountHeadsTextView.text = amountHeadsInt.toString()
        } else {
            amountTailsInt++
            amountTailsTextView.text = amountTailsInt.toString()
        }

    }
}