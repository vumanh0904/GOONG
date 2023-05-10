package com.example.space_smile.screen

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ImageView
//import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.LinearLayoutManager
//import com.example.space_smile.Adapter.ListAdapter
import com.example.space_smile.R
import com.example.space_smile.databinding.ActivitySystemMapBinding
import com.example.space_smile.model.SystemMap
import com.example.space_smile.service.SYSTEMAPI
import com.example.space_smile.service.apiService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SystemMapActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySystemMapBinding
      var systemList = ArrayList<String>()
    //    private lateinit var adapter: ListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySystemMapBinding.inflate(layoutInflater)
        setContentView(binding.root)
        findViewById<TextView>(R.id.action_bar_title).text = "Hệ Thống"
//        binding.lisviewSystem.layoutManager = LinearLayoutManager(this)
//        adapter = ListAdapter(this)
//        binding.lisviewSystem.adapter = adapter

        var arrayAdapter: ArrayAdapter<*>
        // access the listView from xml file
        var mListView = findViewById<ListView>(R.id.lisview_system)
        arrayAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, systemList
        )
        mListView.adapter = arrayAdapter

        val getSystemMap = apiService.getInstance().create(SYSTEMAPI::class.java)


        GlobalScope.launch {
            val result = getSystemMap.getSystem()
            val listSystemName = ArrayList<String>()
            if (result != null){
                val arraylistSystem = (result.body() as ArrayList<SystemMap>)
                for (i in 0 until arraylistSystem.size){
                    listSystemName.add(arraylistSystem[i].systemName)
                }
            }
//            systemList.add(listSystemName.toString())
            systemList = listSystemName
            runOnUiThread {
                arrayAdapter.clear()
                arrayAdapter.addAll(systemList)
                arrayAdapter.notifyDataSetChanged()
            }

            Log.d("5555555",systemList.toString() )

        }

        val actionBarBackButton = findViewById<ImageView>(R.id.action_bar_back_button)
        actionBarBackButton.setOnClickListener {
            onBackPressed()
        }
    }

}