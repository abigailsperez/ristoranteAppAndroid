package com.example.ristorantehttp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import com.example.ristorantehttp.R
import com.example.ristorantehttp.controller.ControllerMenu

class AddMealActivity : AppCompatActivity() {
    private lateinit var name: EditText
    private lateinit var category: EditText
    private lateinit var price: EditText
    private lateinit var available: EditText
    private lateinit var spinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_meal)

        name= findViewById(R.id.name_m)
        category= findViewById(R.id.category_m)
        price= findViewById(R.id.price_m)
        available= findViewById(R.id.available)
    }

    fun eventAddMeal(view: android.view.View) {
        /* var name:String = name.text.toString()
         var restaurant:Long = restaurant.text.toString().toLong()*/

        ControllerMenu().saveMenu(name.text.toString(),category.text.toString().toInt(), price.text.toString().toLong(),available.text.toString().toInt())

        val notification: Toast = Toast.makeText(
            this,
            "Guardado con éxito",
            Toast.LENGTH_SHORT
        )
        notification.show()

        val intent: Intent = Intent(
            this,
            MenuAdminActivity::class.java
        ).apply {}
        startActivity(intent)
    }

    fun viewMenu(view: android.view.View) {
        ControllerMenu().getMenu()
        Toast.makeText(this,view.id.toString(), Toast.LENGTH_LONG).show()
        val intent: Intent = Intent(
            this,
            ShowMenuActivity::class.java
        ).apply {}
        startActivity(intent)
    }

}