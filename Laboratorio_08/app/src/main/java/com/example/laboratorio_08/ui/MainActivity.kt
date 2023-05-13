package com.example.laboratorio_08.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.laboratorio_08.R
import com.example.laboratorio_08.databinding.ActivityMainBinding
import com.example.laboratorio_08.ui.movie.billboard.BillBoardFragment
import com.example.laboratorio_08.ui.movie.viewmodel.MovieViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        supportActionBar!!.hide()
    }

    override fun onBackPressed() {

        val navController = findNavController(R.id.nav_host_fragment)
        if (navController.currentDestination?.id == R.id.billBoardFragment) {
            super.onBackPressed()
        } else {
            navController.navigateUp()
        }
    }

}