package com.example.laboratorio_06.ui.movie.NewMovie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController
import com.example.laboratorio_06.R
import com.example.laboratorio_06.data.model.MovieModel
import com.example.laboratorio_06.data.model.movies
import com.example.laboratorio_06.repositories.MovieRepository

class NewMovieFragment : Fragment() {

    private lateinit var btnSubmit : Button
    private lateinit var editTextName : EditText
    private lateinit var editTextCategory : EditText
    private lateinit var editTextQualification : EditText
    private lateinit var editTextDescription : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_new_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        listeners()
    }



    private fun bind(){
        btnSubmit = view?.findViewById(R.id.save_button) as Button
        editTextName = view?.findViewById(R.id.edit_text_name) as EditText
        editTextCategory = view?.findViewById(R.id.edit_text_category) as EditText
        editTextDescription = view?.findViewById(R.id.edit_text_description) as EditText
        editTextQualification = view?.findViewById(R.id.edit_text_calification) as EditText
    }

    private fun listeners(){

        btnSubmit.setOnClickListener{
            if(!safeNullData()){
                saveData()
                it.findNavController().navigate(R.id.action_newMovieFragment_to_billBoardFragment);
            }
        }
    }

    private fun safeNullData(): Boolean{
        return when{
            editTextName.text.isEmpty() -> true
            editTextCategory.text.isEmpty() -> true
            editTextDescription.text.isEmpty() -> true
            editTextQualification.text.isEmpty() -> true
            else -> false
        }
    }

    private fun saveData(){
        val newMovie = MovieModel(
            editTextName.text.toString(),
            editTextCategory.text.toString(),
            editTextDescription.text.toString(),
            editTextQualification.text.toString())

        MovieRepository(movies).setMovies(newMovie)
    }
}