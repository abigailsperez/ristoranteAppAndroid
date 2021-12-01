package com.example.ristorantehttp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import android.widget.EditText
import com.example.ristorantehttp.controller.ControllerUser
import com.example.ristorantehttp.view.MenuAdminActivity

class MainActivity : AppCompatActivity() {

    private lateinit var email:EditText
    private lateinit var password:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        email = findViewById(R.id.email)
        password = findViewById(R.id.password)

        /*if (email.isFocusable())
            password.requestFocus()*/
    }

    fun eventLogin(view: android.view.View) {
        var value=ControllerUser().login(email.text.toString(), password.text.toString())

        if (value==""){
            val notification: Toast = Toast.makeText(
                this,
                "Inicio de sesión exitoso",
                Toast.LENGTH_SHORT
            )
            notification.show()

            /* Vamos a agregar la nueva actividad */
            val intent: Intent = Intent(
                this,
                MenuAdminActivity::class.java
            ).apply {}
            startActivity(intent)
        }else{
            val notification: Toast = Toast.makeText(
                this,
                "Datos incorrectos",
                Toast.LENGTH_SHORT
            )
            notification.show()
        }
    }


    fun showMenuAdmin(view:View){
        /* Vamos a agregar la nueva actividad */
        val intent:Intent = Intent(
            this,
            MenuAdminActivity::class.java).apply{}
        startActivity(intent)
    }


}