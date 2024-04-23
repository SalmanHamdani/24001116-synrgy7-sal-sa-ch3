package com.salman.chapter3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.salman.chapter3.databinding.FragmentSchoolBinding

class SchoolFragment : Fragment() {
    private var _binding: FragmentSchoolBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSchoolBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val schools = generateSchools()

        val adapter = SchoolAdapter(schools) { school ->
            (activity as MainActivity).openBrowser("http://www.google.com/search?q=${school.name}")
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }

    private fun generateSchools(): List<School> {
        return listOf(
            School("Abydos High School", "http://static.wikia.nocookie.net/blue-archive/images/b/bb/Abydos_Intro.png", "It used to be a thriving and prestigious school before desertification."),
            School("Gehenna Academy", "http://static.wikia.nocookie.net/blue-archive/images/f/f4/Gehenna_Intro.png", "A school that runs along the concept of \"Freedom and Chaos.\" In contrast to its long rival, Trinity."),
            School("Millenium Science School", "http://static.wikia.nocookie.net/blue-archive/images/9/9f/Millennium_Intro.png", "Despite its young age, it has carved its own path to become one of the largest schools in Kivotos."),
            School("Trinity General School", "http://static.wikia.nocookie.net/blue-archive/images/1/19/Trinity_Intro.png", "A seemingly religious school that values order and etiquette. Unlike its long rival, Gehenna."),
            School("Hyakkiyako Alliance Academy", "http://static.wikia.nocookie.net/blue-archive/images/c/c9/Hyakkiyako_Intro.png", "An academy made up of a coalition of numerous different clubs, each with their own cultures and rules."),
            School("Shanhaijing Senior Secondary School", "http://static.wikia.nocookie.net/blue-archive/images/a/af/Shanhaijing_Intro.png", "A school that focuses more on business and commerce, visibly prioritizing money over culture."),
            School("Red Winter Federal Academy", "http://static.wikia.nocookie.net/blue-archive/images/f/f8/Red_Winter_Intro.png", "A snow-covered academy with an emphasis on communal effort."),
            School("Valkyrie Police Academy", "http://static.wikia.nocookie.net/blue-archive/images/2/2e/Valkyrie_Intro.png", "A school responsible for maintaining order and peace all over Kivotos."),
            School("Arius Branch School", "http://static.wikia.nocookie.net/blue-archive/images/f/fa/Arius_Intro.png", "An exiled branch of Trinity, now living hidden underground filled with anger and hatred."),
            School("SRT Special Academy", "http://static.wikia.nocookie.net/blue-archive/images/0/07/SRT_Icon_3.png", "A school of elites that was able to mobilize in any autonomous district through the General Student Council President's authority."),
        )
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
