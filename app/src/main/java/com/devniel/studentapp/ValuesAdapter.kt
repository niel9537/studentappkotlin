package com.devniel.studentapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
class ValuesAdapter(
    val students: ArrayList<ValuesModel.Data>
): RecyclerView.Adapter<ValuesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_mahasiswa, parent, false)
    )

    override fun onBindViewHolder(holder: ValuesAdapter.ViewHolder, position: Int) {
        val data = students[position]
        holder.textStudent.text = data.nama + " "+ data.nim +" "+ data.jurusan
    }

    override fun getItemCount() = students.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val textStudent = view.findViewById<TextView>(R.id.txtMahasiswa)
        val btnDel = view.findViewById<TextView>(R.id.btnDelete)
    }

    public fun setData(data: List<ValuesModel.Data>){
        students.clear()
        students.addAll(data)
        notifyDataSetChanged()
    }
}