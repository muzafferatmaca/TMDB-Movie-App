package com.muzafferatmaca.tmdb_movie_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.muzafferatmaca.tmdb_movie_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }


}