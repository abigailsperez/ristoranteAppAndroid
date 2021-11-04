package com.example.ristorantehttp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ristorantehttp.R

class MenuAdminActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_admin)
    }

    fun eventAdd(view: View){
        var intento: Intent = Intent(
            this
            ,AddCategoryActivity::class.java).apply{}
        startActivity(intento)
    }
}