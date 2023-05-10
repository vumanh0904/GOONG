package com.example.space_smile.screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.example.space_smile.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageList = ArrayList<SlideModel>() // Create image list

        imageList.add(SlideModel("https://bit.ly/2YoJ77H", "The animal population decreased by 58 percent in 42 years."))
        imageList.add(SlideModel("https://bit.ly/2BteuF2", "Elephants and tigers may become extinct."))
        imageList.add(SlideModel("https://bit.ly/3fLJf72", "And people do that."))

        val imageSlider = findViewById<ImageSlider>(R.id.image_slider)
        imageSlider.setImageList(imageList)

        val actionClickLogin = findViewById<Button>(R.id.action_click_login)
        actionClickLogin.setOnClickListener {
            val intent = Intent(this, SettingScreenActivity::class.java)
            startActivity(intent)
        }
    }


}