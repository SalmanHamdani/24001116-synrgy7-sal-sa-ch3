package com.salman.chapter3

import android.content.Intent
import android.os.Bundle
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recycler: RecyclerView
    private lateinit var schools: ArrayList<School>
    lateinit var imageList: Array<Int>
    lateinit var schoolNames: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageList = arrayOf(
            R.drawable.abydos,
            R.drawable.gehenna,
            R.drawable.millennium,
            R.drawable.trinity,
            R.drawable.hyakkiyako,
            R.drawable.shanhaijing,
            R.drawable.red_winter,
            R.drawable.valkyrie,
            R.drawable.arius,
            R.drawable.srt,
        )

        schoolNames = arrayOf(
            "Abydos High School",
            "Gehenna Academy",
            "Millennium Science School",
            "Trinity General School",
            "Hyakkiyako Alliance Academy",
            "Shanhaijing Senior Secondary School",
            "Red Winter Federal Academy",
            "Valkyrie Police Academy",
            "Arius Branch School",
            "SRT Special Academy",
        )

        recycler = findViewById(R.id.recyclerView)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.setHasFixedSize(true)

        schools = arrayListOf<School>()
        getSchools()
    }

    private fun getSchools() {
        for (i in imageList.indices) {
            val school = School(imageList[i], schoolNames[i])
            schools.add(school)
        }
        recycler.adapter = SchoolAdapter(schools)
    }
}
