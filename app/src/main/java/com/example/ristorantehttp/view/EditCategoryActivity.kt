package com.example.ristorantehttp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.ristorantehttp.R
import com.example.ristorantehttp.controller.ControllerCategory

class EditCategoryActivity : AppCompatActivity() {

    private lateinit var name: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_category)
        name= findViewById(R.id.name_c)
    }

    fun editCategory(view: android.view.View) {
        ControllerCategory().updateCategory(name.text.toString())
    }

    fun eventAdd(view: View){
        var intento: Intent = Intent(
            this
            ,AddCategoryActivity::class.java).apply{}
        startActivity(intento)
    }
}