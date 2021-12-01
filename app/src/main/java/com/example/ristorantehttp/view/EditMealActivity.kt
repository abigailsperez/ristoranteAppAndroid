package com.example.ristorantehttp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.ristorantehttp.R
import com.example.ristorantehttp.controller.ControllerMenu

class EditMealActivity : AppCompatActivity() {

    private lateinit var name: EditText
    private lateinit var category: EditText
    private lateinit var price: EditText
    private lateinit var available: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_meal)

        name= findViewById(R.id.name_m)
        category= findViewById(R.id.category_m)
        price= findViewById(R.id.price_m)
        available= findViewById(R.id.available)
    }
    fun editMeal(view: android.view.View) {
        ControllerMenu().updateMenu(name.text.toString(),category.text.toString().toInt(), price.text.toString().toLong(),available.text.toString().toInt() )
    }

    fun eventAdd(view: View){
        var intento: Intent = Intent(
            this
            ,AddMealActivity::class.java).apply{}
        startActivity(intento)
    }
}