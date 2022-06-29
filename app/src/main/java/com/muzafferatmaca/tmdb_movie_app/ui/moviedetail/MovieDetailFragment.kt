package com.muzafferatmaca.tmdb_movie_app.ui.moviedetail

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.muzafferatmaca.tmdb_movie_app.R
import com.muzafferatmaca.tmdb_movie_app.databinding.FragmentMovieDetailBinding
import com.muzafferatmaca.tmdb_movie_app.ui.base.BaseFragment

import kotlinx.android.synthetic.main.fragment_movie_detail.*

class MovieDetailFragment : BaseFragment<FragmentMovieDetailBinding>() {

    override val layoutId: Int = R.layout.fragment_movie_detail
    private lateinit var viewModel: MovieDetailViewModel
    private var movieId: Int = 0
    private val movieDetailCastAdapter = MovieDetailCastAdapter(arrayListOf())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            movieId = MovieDetailFragmentArgs.fromBundle(it).id
        }

        viewModel = ViewModelProvider(this).get(MovieDetailViewModel::class.java)
        viewModel.getMovieDetail(movieId)

        detailMoviePersonRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        detailMoviePersonRecyclerView.setHasFixedSize(true)
        detailMoviePersonRecyclerView.adapter = movieDetailCastAdapter

        observeLiveData()
    }

    fun observeLiveData() {


        viewModel.detailMovie.observe(viewLifecycleOwner) { detailResponse ->

            detailResponse.let {

                binding.movie = it

            }

        }
        viewModel.detailMovieCredits.observe(viewLifecycleOwner) { creditResponse ->

            creditResponse?.let {

                detailMoviePersonRecyclerView.visibility = View.VISIBLE
                movieDetailCastAdapter.castList = it
                movieDetailCastAdapter.notifyDataSetChanged()

            }

        }

    }
}