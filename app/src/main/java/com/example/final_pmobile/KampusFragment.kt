package com.example.final_pmobile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.final_pmobile.adapter.kampusadapter
import com.example.final_pmobile.model.kampus


class KampusFragment : Fragment() {

    lateinit var kampusadapter: kampusadapter
    val lm = LinearLayoutManager(activity)
    val addKampusList: MutableList<kampus> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kampus, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    fun initView() {
        pm_kampus.layoutmanager

    }
}