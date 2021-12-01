package com.example.ristorantehttp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import com.example.ristorantehttp.R

class ShowMenuActivity : AppCompatActivity() {
    private lateinit var name: EditText
    private lateinit var category: EditText
    private lateinit var price: EditText
    private lateinit var available: EditText
    private lateinit var spinner: Spinner
    private var table_menu: TableLayout?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_menu)

        table_menu=findViewById(R.id.table_menu)

        for(i:Int in 0 until 4) {
            val register =
                LayoutInflater.from(this).inflate(R.layout.table_row_menu, null, false)
            val colId: TextView = register.findViewById<View>(R.id.colId) as TextView
            val colName: TextView = register.findViewById<View>(R.id.colName) as TextView
            val colCategory: TextView = register.findViewById<View>(R.id.colCategory) as TextView
            val colPrice: TextView = register.findViewById<View>(R.id.colPrice) as TextView
            val btnEdit: View = register.findViewById<View>(R.id.button_editMeal)
            colId.text = "id $i"
            colName.text = "Nombre $i"
            colCategory.text = "Categoría $i"
            colPrice.text = "Precio $i"
            btnEdit.id = i
            table_menu?.addView(register)
        }
    }

    fun tableEditMeal(view: View){
        Toast.makeText(this,view.id.toString(), Toast.LENGTH_LONG).show()
        val intent: Intent = Intent(
            this,
            EditMealActivity::class.java
        ).apply {}
        startActivity(intent)
    }
}