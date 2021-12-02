package com.example.ristorantehttp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.ristorantehttp.R
import com.example.ristorantehttp.controller.ControllerBill_Menu

class AddBillMenuActivity : AppCompatActivity() {

    private lateinit var bill: EditText
    private lateinit var menu: EditText
    private lateinit var quantity: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_bill_menu)

        bill= findViewById(R.id.bill)
        menu= findViewById(R.id.menu)
        quantity= findViewById(R.id.quantity)
    }

    fun eventButtonAddBill(view: android.view.View) {

        ControllerBill_Menu().saveBill_Menu(bill.text.toString().toLong(),menu.text.toString().toLong(), quantity.text.toString().toLong())

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


}