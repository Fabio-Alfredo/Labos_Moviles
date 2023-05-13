package com.example.laboratorio_08.ui.movie.billboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio_08.R
import com.example.laboratorio_08.adapters.MovieRecyclerViewAdapter
import com.example.laboratorio_08.data.model.MovieModel
import com.example.laboratorio_08.databinding.FragmentBillBoardBinding
import com.example.laboratorio_08.ui.movie.viewmodel.MovieViewModel

class BillBoardFragment : Fragment() {

    private lateinit var binding : FragmentBillBoardBinding
    private  lateinit var adapter: MovieRecyclerViewAdapter

    private val movieViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding  = FragmentBillBoardBinding.inflate(inflater, container , false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listeners()
        setRecyclerView(view)

    }


    private fun listeners(){

        binding.btnLinkNewMovie.setOnClickListener{
            movieViewModel.clearData()
            it.findNavController().navigate(R.id.action_billBoardFragment_to_newMovieFragment)
        }
    }


    private fun showSelectedItem(movie: MovieModel){
        movieViewModel.setSelectedMovie(movie)
        findNavController().navigate(R.id.action_billBoardFragment_to_movieFragment)
    }

    private fun displayMovies(){
        adapter.setData(movieViewModel.getMovies())
        adapter.notifyDataSetChanged()
    }
    private fun setRecyclerView(view: View){
        binding.moviesRecycleView.layoutManager = LinearLayoutManager(view.context)

        adapter = MovieRecyclerViewAdapter { selectedMovie ->
            showSelectedItem(selectedMovie)
        }

        binding.moviesRecycleView.adapter = adapter
        displayMovies()
    }


}
