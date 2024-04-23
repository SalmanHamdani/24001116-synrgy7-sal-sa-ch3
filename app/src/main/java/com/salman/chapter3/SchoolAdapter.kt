package com.salman.chapter3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.salman.chapter3.databinding.ItemSchoolBinding

class SchoolAdapter(
    private val schools: List<School>,
    private val onItemClick: (School) -> Unit
) : RecyclerView.Adapter<SchoolAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemSchoolBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val school = schools[position]
        holder.bind(school)
        holder.itemView.setOnClickListener { onItemClick(school) }
    }

    override fun getItemCount(): Int = schools.size

    inner class ViewHolder(private val binding: ItemSchoolBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(school: School) {
            binding.apply {
                txtName.text = school.name
                txtDescription.text = school.description
                imgSchool.load(school.imageUrl)
            }
        }
    }

}
