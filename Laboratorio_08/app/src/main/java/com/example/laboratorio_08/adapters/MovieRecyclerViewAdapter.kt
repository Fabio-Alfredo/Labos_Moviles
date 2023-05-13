package com.example.laboratorio_08.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio_08.data.model.MovieModel
import com.example.laboratorio_08.databinding.ItemMovieBinding
import java.util.ArrayList


class MovieRecyclerViewAdapter(private val clickListener: (MovieModel)-> Unit): RecyclerView.Adapter<MovieRecyclerViewHolder>() {

    private val movies = ArrayList<MovieModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieRecyclerViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieRecyclerViewHolder(binding)
    }

    override fun getItemCount():Int = movies.size

    override fun onBindViewHolder(holder: MovieRecyclerViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie, clickListener)

       /* movies.let {
            holder.bind(it[position], clickListener)
        }*/
    }

    fun setData(moviesList: List<MovieModel>){
        movies.clear()
        movies.addAll(moviesList)
        notifyDataSetChanged()
    }

}