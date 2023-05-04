package com.example.space_smile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class SettingScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting_screen)
        val actionBarBackButton = findViewById<ImageView>(R.id.action_bar_back_button)
            actionBarBackButton.setOnClickListener {
                onBackPressed()
            }
    }
}