package com.example.labo_02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var Weight_Editext: EditText
    private lateinit var Height_Editext: EditText
    private lateinit var Calculate_Button: Button
    private lateinit var Result_Textview: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        addListener()
    }


    private fun calculateBMI(weight: Float, height: Float): Float {
        return weight / ((height / 100) * (height / 100))
    }

    private fun validateInput(weight: String?, height: String?): Boolean {
        return when {
            weight.isNullOrEmpty() -> {
                Toast.makeText(this, "Height is empty", Toast.LENGTH_SHORT).show()
                return false
            }
            height.isNullOrEmpty() -> {
                Toast.makeText(this, "Height is empty", Toast.LENGTH_SHORT).show()
                return false;
            }
            else -> true
        }
    }

    fun addListener(){
        var weight = Weight_Editext.text.toString().toFloat()
        var height = Height_Editext.text.toString().toFloat()

        Calculate_Button.setOnClickListener {

        }
    }

    fun bind() {
        Weight_Editext = findViewById(R.id.weight_edit_text)
        Height_Editext = findViewById(R.id.height_edit_text)
        Calculate_Button = findViewById(R.id.calculate_button)
        Result_Textview = findViewById(R.id.result_edit_text)
    }

}