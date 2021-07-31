package com.example.final_pmobile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView


class KampusFragment : Fragment() {

    lateinit var  cv : CardView
    private val Lokasi = MapsFragment()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kampus, container, false)

        cv.findViewById<CardView>(R.id.cv_akba).setOnClickListener {

        }


    }


}