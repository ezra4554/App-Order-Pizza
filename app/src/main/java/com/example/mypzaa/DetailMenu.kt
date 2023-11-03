package com.example.mypzaa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class DetailMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_menu)

        val nameTxt = intent.getStringExtra("NAME_TXT")
        val cityTxt = intent.getStringExtra("SELECTED_CITY")
        val titleName = intent.getStringExtra("TITLE_MENU")
        val btnOrder: Button = findViewById(R.id.btnOrderNow)
        val btnBack: Button = findViewById(R.id.btnBack)
        val titleGet: TextView = findViewById(R.id.txtDetailMenu1)
        titleGet.text = titleName

        btnOrder.setOnClickListener{
            val intent = Intent(this@DetailMenu, Order::class.java)
            intent.putExtra("NAME_TXT", nameTxt)
            intent.putExtra("SELECTED_CITY", cityTxt)
            intent.putExtra("TITLE_MENU", titleName)
            startActivity(intent)
            Toast.makeText(applicationContext, "CLICKED", Toast.LENGTH_SHORT).show()
        }
        btnBack.setOnClickListener {
            val intent = Intent(this@DetailMenu, Menu::class.java)
            intent.putExtra("NAME_TXT", nameTxt)
            intent.putExtra("SELECTED_CITY", cityTxt)
            startActivity(intent)
            Toast.makeText(applicationContext, "BACK", Toast.LENGTH_SHORT).show()
        }
    }
}