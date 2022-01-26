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
import com.android.volley.toolbox.JsonRequest
import com.android.volley.toolbox.Volley
import com.example.ristorantehttp.R
import com.example.ristorantehttp.container.ListCategoriaResPonseKT
import com.example.ristorantehttp.controller.ControllerCategory
import com.example.ristorantehttp.services.InterfaceListCategory
import com.example.ristorantehttp.services.Service
import com.google.gson.JsonObject
import com.squareup.moshi.Json
import org.json.JSONException
import org.json.JSONObject
import org.json.JSONArray
import org.json.*
import retrofit2.Call
import javax.security.auth.callback.Callback


class AddCategoryActivity : AppCompatActivity() {

    private lateinit var name: EditText
    private var table_category:TableLayout?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_category)

        name= findViewById(R.id.name)
        table_category=findViewById(R.id.table_category)

        val service = Service.buildService(InterfaceListCategory::class.java)
        val id = 8
        val call= service.getReceive(id.toLong())
        lateinit var listData: ArrayList<String>

        var con= 0

        println("mensaje 1")

        call.enqueue(object :
            retrofit2.Callback<List<ListCategoriaResPonseKT>> {
            override fun onResponse(
                call: Call<List<ListCategoriaResPonseKT>>,
                response: retrofit2.Response<List<ListCategoriaResPonseKT>>
            ) {
                when {
                    response.code() == 200 -> {
                        listData= ArrayList()
                        response.body()!!.forEach {
                            var data = "id"+it.id+
                                    "name"+it+name
                            listData.add(data)
                            println("imprimiendo"+it.id+
                            "nombre"+it.name)
                            con++
                        }
                    }
                    response.code() == 404 -> {
                        println("No se encontraron paquetes registrados")
                    }
                    response.code() == 500 -> {
                        println("Ha occurido un error en el servidor")
                    }
                }
            }

            override fun onFailure(call: Call<List<ListCategoriaResPonseKT>>, t: Throwable) {
                println("No se comunico con el servidor")
            }

        })

        println("mensaje 2")

        /*var queue:RequestQueue=Volley.newRequestQueue(this)
        var url="http://192.168.1.68:8080/api/v1/category/list/2"*/

       /* for(i:Int in 0 until 4) {
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


        val url = "http://192.168.1.68:8080"
        println("hjhjhjhj")
        var jsonObjectRequest = JsonObjectRequest(Request.Method.GET,url,null,
            Response.Listener { response ->
                try {
                    var jsonArray:JSONArray = response.getJSONArray("category")
                    for (i:Int in 0 until jsonArray.length()) {
                        var jsonObject:JSONObject = jsonArray.getJSONObject(i)
                        val register =
                            LayoutInflater.from(this).inflate(R.layout.table_row_category, null, false)
                        val colId: TextView = register.findViewById<View>(R.id.colId) as TextView
                        val colName: TextView = register.findViewById<View>(R.id.colName) as TextView
                        val btnEdit: View = register.findViewById<View>(R.id.button_editCategory)
                        colId.text = jsonObject.getString("id")
                        colName.text = jsonObject.getString("name")
                        println("HOLA mundo")
                        btnEdit.id = jsonObject.getString("id").toInt()
                        table_category?.addView(register)
                    }
                }catch (e:JSONException){
                    e.printStackTrace()
                }
            },Response.ErrorListener { error ->

            }
        )*/
        /*queue.add(jsonObjectRequest)*/


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

    fun tableEdit(view: View){
        val intent: Intent = Intent(
            this,
            EditCategoryActivity::class.java
        ).apply {}
        startActivity(intent)
    }

}