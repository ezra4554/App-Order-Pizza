package com.example.mypzaa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class Store : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store)

        val btnSeeMenus: Button = findViewById(R.id.btnSeeMenu)

        val nameTxt = intent.getStringExtra("NAME_TXT")
        val cityTxt = intent.getStringExtra("SELECTED_CITY")
        val nameGet: TextView = findViewById(R.id.textName)
        val cityGet: TextView = findViewById(R.id.txtCity)
        nameGet.text = "Hello, ${nameTxt}"
        cityGet.text = cityTxt;

        btnSeeMenus.setOnClickListener {
            val intent = Intent(this@Store, Menu::class.java)
            intent.putExtra("NAME_TXT",nameTxt)
            intent.putExtra("SELECTED_CITY", cityTxt)
            startActivity(intent)
            Toast.makeText(applicationContext, "CLICKED", Toast.LENGTH_SHORT).show()
        }
    }
}