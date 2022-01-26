package com.example.ristorantehttp.view

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.ristorantehttp.R

class MenuAdminActivity : AppCompatActivity() {
    lateinit var cerrarSesion: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_admin)

        cerrarSesion= findViewById(R.id.adminCS)

    }

    fun eventAdd(view: View){
        var intento: Intent = Intent(
            this
            ,AddCategoryActivity::class.java).apply{}
        startActivity(intento)
    }

    fun eventAddMeal(view: View){
        var intento2: Intent = Intent(
            this
            ,AddMealActivity::class.java).apply{}
        startActivity(intento2)
    }

    fun eventShowInOut(view: View){
        var intento3: Intent = Intent(
            this
            ,ShowInOutActivity::class.java).apply{}
        startActivity(intento3)
    }

    fun endSession(view: View){
        finish()
    }

    fun changeValue(boolean: Boolean){

    }
}