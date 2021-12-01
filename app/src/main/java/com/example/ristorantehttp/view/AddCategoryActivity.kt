package com.example.ristorantehttp.view
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.ristorantehttp.R
import com.example.ristorantehttp.controller.ControllerCategory
import com.google.gson.JsonObject
import org.json.JSONException
import org.json.JSONObject


class AddCategoryActivity : AppCompatActivity() {

    private lateinit var name: EditText
    private var table_category:TableLayout?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_category)

        name= findViewById(R.id.name)
        table_category=findViewById(R.id.table_category)

        for(i:Int in 0 until 4) {
            val register =
                LayoutInflater.from(this).inflate(R.layout.table_row_category, null, false)
            val colId: TextView = register.findViewById<View>(R.id.colId) as TextView
            val colName: TextView = register.findViewById<View>(R.id.colName) as TextView
            val btnEdit: View = register.findViewById<View>(R.id.button_editCategory)
            colId.text = "id $i"
            colName.text = "Nombre $i"
            btnEdit.id = i
            table_category?.addView(register)
        }

    }

    fun eventButtonAdd(view: android.view.View) {

        ControllerCategory().saveCategory(name.text.toString())

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