package com.example.ristorantehttp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ristorantehttp.R
import com.example.ristorantehttp.controller.ControllerBill

class EditBillMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_bill_menu)
    }

    fun viewBills(view: android.view.View) {
        ControllerBill().getBills()
    }

    fun showBillMenu(view: View){
        var intento: Intent = Intent(
            this
            ,AddBillMenuActivity::class.java).apply{}
        startActivity(intento)
    }
}