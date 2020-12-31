package com.example.coffeeshopapp

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

var coffee_selected: String? = null
var noOfCoffee:Int? = 1
var selected_coffee_price:Int? = 0

class MainActivity : AppCompatActivity() {

    lateinit var option : Spinner
    lateinit var result : TextView

    val options = arrayOf("Cappuccino","Latte","Cafe Mocha")
    val prices = arrayOf(100,90,180)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        option = findViewById(R.id.spinner) as Spinner
        result = findViewById(R.id.coffee_selected) as TextView

        option.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)

        option.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                coffee_selected = options.get(p2)
                selected_coffee_price = prices.get(p2)
                result.text = "You selected : ${options.get(p2)}"
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                result.text = getString(R.string.message)
            }
        }
    }

    fun plusValue(view: View) {
        val x = findViewById<TextView>(R.id.value)
        var v = x.text.toString().toInt()
        v += 1
        noOfCoffee = v
        x.setText("$v")
        //Toast.makeText(this,"toast is $v",Toast.LENGTH_SHORT).show()
    }
    fun minusValue(view: View) {
        val x = findViewById<TextView>(R.id.value)
        var v = x.text.toString().toInt()
        if(v<2)
        {
            Toast.makeText(this,"Ordering Number of Coffee should be greater than zero",Toast.LENGTH_SHORT).show()
        }
        else
        {
            v -= 1
            noOfCoffee = v
            x.setText("$v")
        }
    }

    fun order(view: View) {
        val intent = Intent(this,orderconfirmationactivity::class.java)
        intent.putExtra("coffee type", coffee_selected)
        intent.putExtra("numberOfCoffee", noOfCoffee)
        intent.putExtra("selected_coffee_price",selected_coffee_price)
        startActivity(intent)
    }
}
