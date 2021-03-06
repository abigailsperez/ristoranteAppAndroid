package com.example.ristorantehttp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TableLayout
import android.widget.Toast
import com.example.ristorantehttp.R
import com.example.ristorantehttp.controller.ControllerBill
import com.example.ristorantehttp.controller.ControllerCategory

class AddBillActivity : AppCompatActivity() {

    private lateinit var dinning_table: EditText
    private lateinit var user: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_bill)

        dinning_table= findViewById(R.id.dinning_table)
        user= findViewById(R.id.user)
    }


    fun eventButtonAddBill(view: android.view.View) {

        ControllerBill().saveBill(dinning_table.text.toString().toLong(),user.text.toString().toLong())

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

    fun viewBills(view: android.view.View) {
        ControllerBill().getBills()
    }
}