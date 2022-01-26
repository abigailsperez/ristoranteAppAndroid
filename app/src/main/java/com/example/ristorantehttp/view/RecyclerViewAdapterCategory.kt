package com.example.ristorantehttp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ristorantehttp.R
import com.example.ristorantehttp.model.entity.Category
import kotlinx.android.synthetic.main.recycler_category_row_list.view.*

class RecyclerViewAdapterCategory (val clickListener: OnItemClickListener): RecyclerView.Adapter<RecyclerViewAdapterCategory.MyViewHolder>()  {

    var userList = mutableListOf<Category>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapterCategory.MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.recycler_category_row_list, parent, false)
        return MyViewHolder(inflater)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapterCategory.MyViewHolder, position: Int) {
        holder.bind(userList[position])
        holder.itemView.setOnClickListener {
            clickListener.onItemEditCLick(userList[position])
        }
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val textViewName = view.textViewName
        /*val textViewEmail = view.textViewEmail
        val textViewStats = view.textViewStats*/

        fun bind(data : Category) {
            textViewName.text = data.name
            /*textViewEmail.text = data.email
            textViewStats.text = data.status*/
        }
    }

    interface OnItemClickListener {
        fun onItemEditCLick(user : Category)
    }
}