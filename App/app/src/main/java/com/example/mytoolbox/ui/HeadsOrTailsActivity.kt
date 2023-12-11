package com.example.mytoolbox.ui

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextSwitcher
import android.widget.TextView
import android.widget.Toast
import android.widget.ViewSwitcher
import androidx.appcompat.app.AppCompatActivity
import com.example.mytoolbox.MainActivity
import com.example.mytoolbox.R


class HeadsOrTailsActivity : AppCompatActivity() {
    lateinit var coinImageView: ImageView
    lateinit var headsOrTailsButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heads_or_tails)


        val backButton = findViewById<Button>(R.id.hodbackButton)
        headsOrTailsButton = findViewById<Button>(R.id.TossCoin)




        coinImageView = findViewById<ImageView>(R.id.coinImageView)


        backButton.setOnClickListener{
            val intent = Intent (this, MainActivity::class.java)
            this.startActivity(intent)
        }

        headsOrTailsButton.setOnClickListener{
            val randomNumber = (1..2).random()

            if (randomNumber == 1){
                flipTheCoin(R.drawable.ic_coin_heads, "Heads")
            } else {
                flipTheCoin(R.drawable.ic_coin_tails, "Tails")
            }

        }

    }
    private fun flipTheCoin(imageId: Int, coinSide:String){
        coinImageView.animate().apply {
            coinImageView.setImageResource(R.drawable.ic_coin_empty)
            duration = 1000
            rotationYBy(1800f)
            headsOrTailsButton.isClickable = false
        }.withEndAction {
            coinImageView.setImageResource(imageId)
            Toast.makeText(this, coinSide, Toast.LENGTH_SHORT).show()
            headsOrTailsButton.isClickable = true
        }
    }
}