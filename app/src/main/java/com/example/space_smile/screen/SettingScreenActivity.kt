package com.example.space_smile.screen

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.databinding.ViewDataBinding
import com.example.space_smile.R
import com.example.space_smile.databinding.ActivityMainBinding
import com.example.space_smile.databinding.ActivitySettingScreenBinding
import com.example.space_smile.model.Gps
import com.example.space_smile.service.GPSAPI
import com.example.space_smile.service.apiService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SettingScreenActivity : AppCompatActivity() {
//    private  var gpsConnect: Gps = Gps("1",1)

    private lateinit var binding: ActivitySettingScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
//        binding.tvTitleGPSConnect.text = gpsConnect.number.toString()
//        lấy dữ liệu từ api
        val getGps = apiService.getInstance().create(GPSAPI::class.java)

        GlobalScope.launch {
            val result = getGps.getGPS()
            if (result != null){
                val firstItem = (result.body() as ArrayList<Gps>)[0]
                 val gpsConnect = firstItem
                binding.tvTitleGPSConnect.text = gpsConnect.number.toString()
            }
        }
        val actionBarBackButton = findViewById<ImageView>(R.id.action_bar_back_button)
        actionBarBackButton.setOnClickListener {
            onBackPressed()
        }
    }
}
