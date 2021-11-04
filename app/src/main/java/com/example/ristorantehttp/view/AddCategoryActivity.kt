package com.example.ristorantehttp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.ristorantehttp.R
import com.example.ristorantehttp.controller.ControllerCategory

class AddCategoryActivity : AppCompatActivity() {

    private lateinit var name: EditText
    private lateinit var restaurant: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_category)

        name= findViewById(R.id.name)
        restaurant= findViewById(R.id.restaurant)
    }

    fun eventButtonAdd(view: android.view.View) {
       /* var name:String = name.text.toString()
        var restaurant:Long = restaurant.text.toString().toLong()*/

        ControllerCategory().saveCategory(name.text.toString(), restaurant.text.toString().toLong())

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
    fun viewCategorys(view: android.view.View) {
        ControllerCategory().getCategorys()
    }
}