package com.example.mytoolbox.ui

import android.content.ClipData
import android.content.ClipDescription
import android.content.ClipboardManager
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.mytoolbox.MainActivity
import com.example.mytoolbox.R


class QRResultScreenActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qrresult_screen)

        val backButton = findViewById<Button>(R.id.QRresbackButton)
        val rescanButton = findViewById<Button>(R.id.rescanButton)
        val qrresultView = findViewById<TextView>(R.id.qrresultView)
        val openLinkbutton = findViewById<Button>(R.id.openLinkButton)
        val copyResultButton = findViewById<Button>(R.id.copyResultButton)

        val scanResult:String = intent.getStringExtra("qrresult").toString()
        qrresultView.text = scanResult

        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            this.startActivity(intent)
        }
        rescanButton.setOnClickListener {
            val intent = Intent(this, QRscannerActivity::class.java)
            this.startActivity(intent)
        }
        openLinkbutton.setOnClickListener {
            if (scanResult.contains("http")) {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(scanResult))
                startActivity(browserIntent)
            } else {
                Toast.makeText(this, "Not a valid URL.", Toast.LENGTH_LONG).show()
            }
        }

        copyResultButton.setOnClickListener{
            val clipboardManager =
                applicationContext.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText(
                "Clip Data", scanResult
            )
                .apply {
                    description.extras = PersistableBundle().apply {
                        // only available for Android13 or higher
                        putBoolean(ClipDescription.MIMETYPE_TEXT_PLAIN, true)
                    }
                }
            clipboardManager.setPrimaryClip(clipData)
        }



    }
}