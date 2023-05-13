package com.example.laboratorio_08.repositories

import com.example.laboratorio_08.data.model.MovieModel

class MovieRepository (private  val movies: MutableList<MovieModel>){

    fun getMovies () = movies

    fun setMovies (movie: MovieModel) = movies.add(movie)
}