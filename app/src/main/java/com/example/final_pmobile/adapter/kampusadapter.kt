package com.example.final_pmobile.adapter

import android.content.Context
import android.text.method.TextKeyListener.clear
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.final_pmobile.KampusFragment
import com.example.final_pmobile.R
import com.example.final_pmobile.model.kampus
import java.util.Collections.addAll

class kampusadapter (val context: Context):RecyclerView.Adapter<kampusadapter.MovieViewHolder>(){

    private val movies: MutableList<kampus> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(context).inflate(R.layout.adapter_kampus, parent, false))
    }

    override fun onBindViewHolder(holder: kampusadapter.MovieViewHolder, position: Int) {
        holder.bindmodel(movies[position])
    }

    override fun getItemCount(): Int {
       return movies.size
    }
    fun setMovie(data: List<kampus>){
        movies.clear()
        movies.addAll(data)
        notifyDataSetChanged()
    }

    inner class MovieViewHolder(item: View): RecyclerView.ViewHolder(item){

        val txtTitle: TextView = item.findViewById(R.id.stimik)
        val txtDescription: TextView = item.findViewById(R.id.deskstimik)

        fun bindmodel(m: kampus){

            txtTitle.text = m.getTitle()
            txtDescription.text = m.getDescription()
        }
    }
}