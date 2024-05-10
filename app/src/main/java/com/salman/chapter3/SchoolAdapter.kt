package com.salman.chapter3

import SchoolDetailFragment
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.salman.chapter3.databinding.ItemSchoolBinding

class SchoolAdapter(
    private val schools: ArrayList<School>
) : RecyclerView.Adapter<SchoolAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_school, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return schools.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentSchool = schools[position]
        holder.rvImage.setImageResource(currentSchool.image)
        holder.rvName.setText(currentSchool.name)

        holder.itemView.setOnClickListener {
            val selectedSchool = schools[position]
            val bundle =    Bundle().apply {
                putParcelable("selectedSchool", selectedSchool)
            }
            val fragment = SchoolDetailFragment()
            fragment.arguments = bundle
            (holder.itemView.context as AppCompatActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
        }

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rvImage: ImageView = itemView.findViewById(R.id.imgSchool)
        val rvName: TextView = itemView.findViewById(R.id.tvName)
    }
}
