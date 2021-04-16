package com.example.room_recyclerview_livedataexample.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.room_recyclerview_livedataexample.R
import com.example.room_recyclerview_livedataexample.db.componets.entity.Student
import kotlinx.android.synthetic.main.custom_view.view.*

class MyRecyclerViewAdapter(val students: List<Student>):RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.custom_view,parent,false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.id.text = students[position].id.toString()
        holder.name.text = students[position].name    }

    override fun getItemCount(): Int {
        return students.size
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }


    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val id = itemView.tvId
        val name = itemView.tvName

    }

}