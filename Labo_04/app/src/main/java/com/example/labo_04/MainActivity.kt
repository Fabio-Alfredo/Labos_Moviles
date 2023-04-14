package com.example.labo_04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var name: EditText
    private lateinit var phoneNumber: EditText
    private lateinit var email: EditText
    private lateinit var save: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        addListener()
    }

    fun bind(){
        name = findViewById(R.id.editText_name)
        phoneNumber=findViewById(R.id.phone_number_text)
        email=findViewById(R.id.email_text)
        save = findViewById(R.id.save_button)
    }


    fun addListener(){
        save.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)

                val fieldName = name.text.toString()
                val fieldEmail = email.text.toString()
                val fieldPhoneNumber = phoneNumber.text.toString()

            intent.putExtra("name", fieldName)
            intent.putExtra("email", fieldEmail)
            intent.putExtra("phone",fieldPhoneNumber)

            startActivity(intent)
        }
    }

}