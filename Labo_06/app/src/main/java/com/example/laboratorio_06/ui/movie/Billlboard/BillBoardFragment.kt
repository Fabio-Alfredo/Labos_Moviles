package com.example.laboratorio_06.ui.movie.Billlboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio_06.R
import com.example.laboratorio_06.data.adapter.MovieAdapter
import com.example.laboratorio_06.data.model.movies
import com.example.laboratorio_06.repositories.MovieRepository
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BillBoardFragment : Fragment() {

    private lateinit var buttonFragmentNewMovie: FloatingActionButton
    private lateinit var recyclerViewMovies: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bill_board, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        listeners()

        val repository = MovieRepository(movies)
        val adapter = MovieAdapter()
        adapter.setData(repository.getMovies())

        recyclerViewMovies.adapter = adapter
        recyclerViewMovies.layoutManager = LinearLayoutManager(context)
    }

    private fun bind(){
        buttonFragmentNewMovie = view?.findViewById(R.id.btn_link_new_movie) as FloatingActionButton
        recyclerViewMovies = view?.findViewById(R.id.recycleView_movie) as RecyclerView
    }

    private fun listeners(){
        buttonFragmentNewMovie.setOnClickListener{
            it.findNavController().navigate(R.id.action_billBoardFragment_to_newMovieFragment)
        }

    }
}
