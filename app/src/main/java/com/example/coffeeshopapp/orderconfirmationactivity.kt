package com.example.coffeeshopapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class orderconfirmationactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orderconfirmationactivity)

        val coffee_name = intent.getStringExtra("coffee type")
        val noOfCoffee = intent.getIntExtra("numberOfCoffee",1)
        val selected_coffee_price = intent.getIntExtra("selected_coffee_price",0)

        val coffee_name_value = findViewById<TextView>(R.id.coffee_name_value)
        coffee_name_value.text = coffee_name

        val coffee_quantity_value = findViewById<TextView>(R.id.coffee_quantity_value)
        coffee_quantity_value.text = noOfCoffee.toString()

        val coffee_price_value = findViewById<TextView>(R.id.coffee_price_value)
        coffee_price_value.text = selected_coffee_price.toString()

        val total_value = findViewById<TextView>(R.id.total_value)
        total_value.text = (noOfCoffee*selected_coffee_price).toString()

    }
}
