package com.example.mytoolbox.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.mytoolbox.MainActivity
import com.example.mytoolbox.R
import java.util.*

class WordGeneratorActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word_generator)



        val backButton = findViewById<Button>(R.id.wgbackButton)
        val nameGeneratorButton = findViewById<Button>(R.id.generateWordButton)
        val textViewResult = findViewById<TextView>(R.id.wordGeneratedView)


        backButton.setOnClickListener{
            val intent = Intent (this, MainActivity::class.java)
            this.startActivity(intent)
        }
        nameGeneratorButton.setOnClickListener{
            val namesArray = listOf("approval","screw","blood","loss","support","play","ray","back","quince","coal","price","relation","bag","ink","tray","kettle","celery","agreement","power","alarm","teeth","cattle","jam","toy","finger","rose","meat","laugh","root","quarter","steel","sleet","airport","stew","tank","desk","trucks","yoke","neck","box","honey","sack","cracker","camera","run","man","business","tub","cub","window","cabbage","bat","rat","bed","popcorn","seed","fruit","oil","cover","crown","grape","cat","elbow","behavior","fowl","volcano","slope","glass","cellar","sun","engine","expert","deer","smell","table","tomatoes","industry","dust","calendar","eggs","hand","interest","pest","cats","walk","face","kitty","crib","foot","coach","laborer","wound","daughter","letters","scarecrow","step","throat","sisters","nose","songs","education","school","side","stomach","cast","question","nerve","eyes","science","door","wind","needle","mailbox","invention","legs","clam","winter","advice","dog","snail","hall","cobweb","spy","story","pen","birthday","doll","squirrel","geese","space","bear","thunder","dirt","month","hammer","shoes","basin","blow","flesh","heat","men","sea","sticks","angle","cannon","servant","locket","fish","mint","spiders","boat","instrument","treatment","cemetery","basket","knee","bait","hat","produce","pump","cakes","oven","train","route","house","machine","north","baby","sign","grandmother","rifle","advertisement","yak","money","eye","town","seashore","wool","flight","pet","minute","knowledge","market","blade","pleasure","thing","sock","grain","distance","error","harmony","snake","event","turn","zipper","hour","crook","yarn","texture","basketball","brass","pail","person","expansion","flame","brother","roof","dogs","twist","roll","place","cook","vegetable","swing","title","fuel","hate","name","van","flower","friends","collar","wealth","cause","birth","prose","earthquake","building","coil","spoon","lace","station","trains","limit","idea","stamp","ring","shame","government","move","mass","reason","number","smile","sense","woman","pull","stage","stocking","love")
            val randomIntOfArray = (1..namesArray.size).random()

            textViewResult.text = namesArray[randomIntOfArray].replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(
                    Locale.ROOT
                ) else it.toString()
            }
        }
    }

}