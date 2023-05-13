package com.example.laboratorio_08.ui.movie.visMovie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.laboratorio_08.databinding.FragmentMovieBinding
import com.example.laboratorio_08.ui.movie.viewmodel.MovieViewModel


class MovieFragment : Fragment() {

    private lateinit var binding : FragmentMovieBinding

    private val movieViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewmodel = movieViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding  = FragmentMovieBinding.inflate(inflater, container , false)
        return binding.root

    }


}