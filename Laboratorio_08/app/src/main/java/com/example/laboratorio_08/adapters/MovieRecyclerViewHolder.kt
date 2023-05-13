package com.example.laboratorio_08.adapters

import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio_08.data.model.MovieModel
import com.example.laboratorio_08.databinding.ItemMovieBinding

class MovieRecyclerViewHolder(private val binding: ItemMovieBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(movie : MovieModel, clickListener: (MovieModel) -> Unit){

        binding.textViewName.text = movie.name
        binding.textViewQualification.text = movie.qualification

        binding.cardViewMovie.setOnClickListener{
            clickListener(movie)
        }
    }
}