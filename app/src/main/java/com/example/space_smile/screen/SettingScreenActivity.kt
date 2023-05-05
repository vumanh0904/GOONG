package com.example.space_smile.screen

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.space_smile.R
import com.example.space_smile.databinding.ActivityMainBinding
import com.example.space_smile.model.Gps
import com.example.space_smile.service.GPSAPI
import com.example.space_smile.service.apiService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SettingScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_setting_screen)
        val actionBarBackButton = findViewById<ImageView>(R.id.action_bar_back_button)
            actionBarBackButton.setOnClickListener {
                onBackPressed()
            }
//        lấy dữ liệu từ api
        val getGps = apiService.getInstance().create(GPSAPI::class.java)

        GlobalScope.launch {
            val result = getGps.getGPS()
            if (result != null){
                val firstItem = (result.body() as ArrayList<Gps>)[0]
                val gpsConnect = firstItem.number.toString()
                binding = ActivityMainBinding.inflate(layoutInflater)
                setContentView(binding.root)
//                binding.setting_text_display_gpsConnect_right.setText(gpsConnect)

            }
        }
    }
}
