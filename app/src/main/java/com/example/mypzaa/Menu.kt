package com.example.mypzaa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val nameTxt = intent.getStringExtra("NAME_TXT")?:""
        val cityTxt = intent.getStringExtra("SELECTED_CITY")?:""
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val nameGet: TextView = findViewById(R.id.textName)

        nameGet.text = "Hello, ${nameTxt}"
        recyclerView.layoutManager = LinearLayoutManager(this)

        val dataList = listOf(
            DataModel(R.drawable.pizza, getString(R.string.menu1), getString(R.string.desc_menu), nameTxt, cityTxt),
            DataModel(R.drawable.burger, getString(R.string.menu2), getString(R.string.desc_menu), nameTxt, cityTxt, 0),
            DataModel(R.drawable.sandwich, getString(R.string.menu3), getString(R.string.desc_menu), nameTxt, cityTxt, 0),
            DataModel(R.drawable.fries, getString(R.string.menu4), getString(R.string.desc_menu), nameTxt, cityTxt, 0),
        )

        val adapter = MyAdapter(dataList, applicationContext, this@Menu)
        recyclerView.adapter = adapter

    }
}