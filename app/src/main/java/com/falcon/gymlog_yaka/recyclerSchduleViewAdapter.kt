package com.falcon.gymlog_yaka

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class recyclerSchduleViewAdapter(private var dataList: List<String?>) : RecyclerView.Adapter<recyclerSchduleViewAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Define references to the views in the item layout
        val textView: TextView = itemView.findViewById(R.id.ScheduleNameTxt)
    }

    fun updateData(dList:List<String?>){
        dataList = dList
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // Inflate the item layout and create a ViewHolder
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.schedule_row_view, parent, false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // Bind data to the views in each item
        val data = dataList[position]
        holder.textView.text = data
        Log.e("Tag charlie : ", "onBind ok")
    }
    override fun getItemCount(): Int {
        // Return the number of items in the data list
        return dataList.size
    }
}

