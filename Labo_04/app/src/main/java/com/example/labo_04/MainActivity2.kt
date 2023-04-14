package com.example.labo_04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {

    private lateinit var shareButton: Button

    private var fieldName=""
    private var fieldEmail=""
    private var fieldPhoneNumber=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        fieldName=intent.getStringExtra("name").toString()
        fieldEmail=intent.getStringExtra("email").toString()
        fieldPhoneNumber = intent.getStringExtra("email").toString()

        findViewById<TextView>(R.id.field_name)?.let { it.text = fieldName }
        findViewById<TextView>(R.id.field_email)?.let { it.text = fieldEmail }
        findViewById<TextView>(R.id.field_phone)?.let { it.text=fieldPhoneNumber}

        bind()
        addListener()
    }

    private fun bind(){
        shareButton = findViewById(R.id.share_button)
    }

    private fun addListener() {

        shareButton.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(
                    Intent.EXTRA_TEXT, getString(R.string.share_text, fieldName,
                    fieldEmail, fieldPhoneNumber))
                type = "text/plain"
                }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }
    }
}