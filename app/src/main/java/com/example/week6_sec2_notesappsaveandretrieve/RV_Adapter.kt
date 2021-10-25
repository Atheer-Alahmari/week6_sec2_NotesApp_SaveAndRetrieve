package com.example.week6_sec2_notesappsaveandretrieve

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*

class RV_Adapter (private val listOf_Note:ArrayList<String>): RecyclerView.Adapter<RV_Adapter.ItemViewHolder>() {
    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row,
                parent,
                false
            )
        )    }

    override fun onBindViewHolder(holder:ItemViewHolder, position: Int) {
        val note = listOf_Note[position]

        holder.itemView.apply {
            text_View.text = note
        }    }

    override fun getItemCount()=listOf_Note.size
}