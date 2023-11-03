package com.example.mypzaa

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewParent
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner: Spinner = findViewById(R.id.spinnerMain)
        val city: Array<String> = resources.getStringArray(R.array.spinner_items)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, city)
        val submitBtn: Button = findViewById(R.id.submitMainBtn)
        val cityName: EditText =findViewById(R.id.editTextMain)
        val nameTxt: EditText = findViewById(R.id.editTextMain2)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long){
                val selectedCity = city[position]
                if (selectedCity == "Bandung"){
                    cityName.setText("Cibiru")
                }else{
                    cityName.setText("Pasar Senen")
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?){
                //
            }
        }
//        nameTxt.setOnEditorActionListener { _, actionId, _ ->
//            if (actionId == EditorInfo.IME_ACTION_DONE) {
//                // Dismiss the keyboard
//                val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//                inputMethodManager.hideSoftInputFromWindow(nameTxt.windowToken, 0)
//                return@setOnEditorActionListener true
//            }
//            false
//        }

        submitBtn.setOnClickListener{
            val selectedCity = spinner.selectedItem.toString()
            val inputName = nameTxt.text.toString()
            val intent = Intent(this@MainActivity, Store::class.java)
            intent.putExtra("NAME_TXT", inputName)
            intent.putExtra("SELECTED_CITY", selectedCity)
            startActivity(intent)
            Toast.makeText(applicationContext, "clicked submit", Toast.LENGTH_SHORT).show()
        }
    }
}