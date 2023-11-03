package com.example.mypzaa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast

class Order : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val nameTxt = intent.getStringExtra("NAME_TXT")
        val cityTxt = intent.getStringExtra("SELECTED_CITY")
        val titleMenu = intent.getStringExtra("TITLE_MENU")
        val orderName = findViewById<TextView>(R.id.txtOrder2)
        val orderStoreName = findViewById<TextView>(R.id.txtOrder3)
        val orderMenuName = findViewById<TextView>(R.id.txtOrder4)
        val btnFinish: Button = findViewById(R.id.btnDone)
        val delivOne: CheckBox = findViewById(R.id.checkBox1)
        val delivTwo: CheckBox = findViewById(R.id.checkBox2)
        orderName.text = "Name ${nameTxt}"
        orderStoreName.text = "Store: ${cityTxt}"
        orderMenuName.text = "${titleMenu} sudah dipesan"


        var isCheckedDelivOne = false
        var isCheckedDelivTwo = false

        delivOne.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // Checkbox 1 dipilih
                if (isCheckedDelivTwo) {
                    // Jika checkbox 2 sudah dipilih, setel checkbox 2 menjadi tidak dipilih
                    delivTwo.isChecked = false
                    isCheckedDelivTwo = false
                }
                isCheckedDelivOne = true
            } else {
                // Checkbox 1 tidak dipilih
                isCheckedDelivOne = false
            }
        }

        delivTwo.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // Checkbox 2 dipilih
                if (isCheckedDelivOne) {
                    // Jika checkbox 1 sudah dipilih, setel checkbox 1 menjadi tidak dipilih
                    delivOne.isChecked = false
                    isCheckedDelivOne = false
                }
                isCheckedDelivTwo = true
            } else {
                // Checkbox 2 tidak dipilih
                isCheckedDelivTwo = false
            }
        }

        btnFinish.setOnClickListener {
            if (isCheckedDelivOne) {
                Toast.makeText(
                    applicationContext,
                    "Terima kasih Pa ${nameTxt} sudah memesan ditoko kami, pesanan ${titleMenu} anda silahkan ambil di toko",
                    Toast.LENGTH_LONG
                ).show()
            } else if (isCheckedDelivTwo){
                Toast.makeText(
                    applicationContext,
                    "Terima kasih Pa ${nameTxt} sudah memesan ditoko kami, pesanan ${titleMenu} anda dikirim menggunakan Fast Delivery",
                    Toast.LENGTH_LONG
                ).show()
            } else{
                Toast.makeText(
                    applicationContext,
                    "Silahkan Pilih Metode Pengiriman",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}