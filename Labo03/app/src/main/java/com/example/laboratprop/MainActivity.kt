package com.example.laboratprop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var Counter: TextView
    private lateinit var five_cents: ImageButton
    private lateinit var ten_cents: ImageButton
    private lateinit var quarter_cents: ImageButton
    private lateinit var one_dola: ImageButton
    private var money = 0.00

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bind()
        addListeners()
    }

    private fun addListeners(){
        five_cents.setOnClickListener{addMoney(0.05)}
        ten_cents.setOnClickListener{addMoney(0.10)}
        quarter_cents.setOnClickListener{addMoney(0.25)}
        one_dola.setOnClickListener{addMoney(1.00)}
    }

    private fun addMoney(totalCount: Double){
        money += totalCount
        Counter.text= getString(R.string.money_value, String.format("%.2f", money))
    }

    private fun bind(){
        Counter = findViewById(R.id.counter_money)
        five_cents = findViewById(R.id.imageButton_nickle)
        ten_cents = findViewById(R.id.imageButton_dime)
        quarter_cents = findViewById(R.id.imageButton_quarter)
        one_dola = findViewById(R.id.imageButton_dollar)
    }
}

