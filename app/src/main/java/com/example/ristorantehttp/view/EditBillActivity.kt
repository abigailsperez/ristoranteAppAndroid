package com.example.ristorantehttp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.ristorantehttp.R
import com.example.ristorantehttp.controller.ControllerBill
import com.example.ristorantehttp.controller.ControllerCategory

class EditBillActivity : AppCompatActivity() {

    private lateinit var dinning_table: EditText
    private lateinit var user: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_bill)

        dinning_table= findViewById(R.id.dinning_table)
        user= findViewById(R.id.user)
    }

    fun editBill(view: android.view.View) {
        ControllerBill().updateBill(dinning_table.text.toString().toLong(),user.text.toString().toLong())
    }

    fun return_bill(view: View){
        var intento: Intent = Intent(
            this
            ,AddBillActivity::class.java).apply{}
        startActivity(intento)
    }
}