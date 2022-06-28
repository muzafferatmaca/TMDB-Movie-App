package com.muzafferatmaca.tmdb_movie_app.ui.moviedetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.muzafferatmaca.tmdb_movie_app.R
import com.muzafferatmaca.tmdb_movie_app.databinding.FragmentMovieDetailBinding
import com.muzafferatmaca.tmdb_movie_app.ui.base.BaseFragment
import com.muzafferatmaca.tmdb_movie_app.ui.home.HomeAdapter
import com.muzafferatmaca.tmdb_movie_app.ui.home.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class MovieDetailFragment : BaseFragment<FragmentMovieDetailBinding>() {

    override val layoutId: Int = R.layout.fragment_movie_detail
    private lateinit var viewModel: MovieDetailViewModel
    private var movieId: Int = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            movieId = MovieDetailFragmentArgs.fromBundle(it).id
        }

        viewModel = ViewModelProvider(this).get(MovieDetailViewModel::class.java)
        viewModel.getMovieDetail(movieId)
        observeLiveData()
    }

    fun observeLiveData() {


        viewModel.detailMovie.observe(viewLifecycleOwner) { detailResponse ->

            detailResponse.let {

                binding.movie=it

            }

        }

    }


}