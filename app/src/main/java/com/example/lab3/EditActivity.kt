package com.example.lab3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class EditActivity : AppCompatActivity() {

    private lateinit var edtName: EditText
    private lateinit var btnSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        edtName = findViewById(R.id.edtName)
        btnSave = findViewById(R.id.btnSave)

        val currentName = intent.getStringExtra("KEY_NAME") ?: ""
        if (currentName != "Chưa có thông tin") {
            edtName.setText(currentName)
        }

        btnSave.setOnClickListener {
            val newName = edtName.text.toString().trim()
            val returnIntent = Intent().apply {
                putExtra("KEY_NAME", newName)
            }
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }
    }
}