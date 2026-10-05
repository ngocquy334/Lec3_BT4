package com.example.lab3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tvName: TextView
    private lateinit var btnEdit: Button

    private val editLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val updatedName = result.data?.getStringExtra("KEY_NAME")
            if (!updatedName.isNullOrBlank()) {
                tvName.text = updatedName
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvName = findViewById(R.id.tvName)
        btnEdit = findViewById(R.id.btnEdit)

        tvName.text = "Chưa có thông tin"

        btnEdit.setOnClickListener {
            val intent = Intent(this, EditActivity::class.java).apply {
                putExtra("KEY_NAME", tvName.text.toString())
            }
            editLauncher.launch(intent)
        }
    }
}