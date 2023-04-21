package com.example.laboratorio_05.ui.NewMovie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.example.laboratorio_05.R


class NewMovie_Fragment : Fragment() {


    private lateinit var Save_button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_newmovie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        listeners()
    }

    private fun bind(){
        Save_button = view?.findViewById(R.id.save_button) as Button
    }

    private fun listeners(){
        Save_button.setOnClickListener{
            it.findNavController().navigate(R.id.action_newMovie_Fragment_to_billBoard_Fragment)
        }
    }
}