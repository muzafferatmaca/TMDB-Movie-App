package com.muzafferatmaca.tmdb_movie_app.ui.home.movies

import android.os.Bundle

import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.muzafferatmaca.tmdb_movie_app.R
import com.muzafferatmaca.tmdb_movie_app.databinding.FragmentMovieDetailBinding
import com.muzafferatmaca.tmdb_movie_app.model.homemodel.search.SearchResult
import com.muzafferatmaca.tmdb_movie_app.ui.base.BaseFragment
import com.muzafferatmaca.tmdb_movie_app.ui.home.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home_movies.*

 class HomeMoviesFragment : BaseFragment<FragmentMovieDetailBinding>(){

    override val layoutId: Int = R.layout.fragment_home_movies
    private lateinit var viewModel: HomeViewModel
    private val homeMoviesAdapter = HomeMoviesAdapter(arrayListOf())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
    //    viewModel.getSearchVM()




        recyclerViewHomeMovie.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewHomeMovie.setHasFixedSize(true)
        recyclerViewHomeMovie.adapter = homeMoviesAdapter

        searchObserveLiveData()
    }

  private   fun searchObserveLiveData() {

      /*  viewModel.searchMovie.observe(viewLifecycleOwner) {  searchResponse ->
            println("test")
            searchResponse.searchResults?.let {

                println("test $it")
                recyclerViewHomeMovie.visibility = View.VISIBLE
                homeMoviesAdapter.movieList = it as List<SearchResult>
                homeMoviesAdapter.notifyDataSetChanged()

            }

        }*/

    }

}