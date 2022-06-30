package com.muzafferatmaca.tmdb_movie_app.ui.home

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.muzafferatmaca.tmdb_movie_app.R
import com.muzafferatmaca.tmdb_movie_app.databinding.FragmentHomeBinding
import com.muzafferatmaca.tmdb_movie_app.ui.base.BaseFragment
import com.muzafferatmaca.tmdb_movie_app.ui.home.movies.HomeMoviesFragment
import com.muzafferatmaca.tmdb_movie_app.ui.home.people.HomePeopleFragment
import com.muzafferatmaca.tmdb_movie_app.ui.home.tv.HomeTvFragment
import com.muzafferatmaca.tmdb_movie_app.utils.hideSoftKeyboard
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override val layoutId: Int = R.layout.fragment_home
    private lateinit var viewModel: HomeViewModel
    private val homeAdapter = HomeAdapter(arrayListOf())
    var queryString: String? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpTabs()

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        viewModel.getPopularMovieVM()

        recyclerViewHome.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewHome.setHasFixedSize(true)
        recyclerViewHome.adapter = homeAdapter

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                if (newText == null || newText.trim().isEmpty()) {
                    recyclerViewHome.visibility = View.VISIBLE
                    appBarLayout.visibility = View.GONE
                    homeViewPager.visibility = View.GONE
                } else {
                    recyclerViewHome.visibility = View.GONE
                    appBarLayout.visibility = View.VISIBLE
                    homeViewPager.visibility = View.VISIBLE
                }

                hideSoftKeyboard(this@HomeFragment)

                queryString = newText.toString()

               lifecycleScope.launchWhenResumed {
                   childFragmentManager.setFragmentResult("requestKey", bundleOf("data" to queryString))

               }

                return true
            }

        })
popularMovieObserveLiveData()
    }

    private fun popularMovieObserveLiveData() {

        viewModel.popularMovie.observe(viewLifecycleOwner) { movieResponse ->

            movieResponse.results?.let {

                homeAdapter.movieList = it
                homeAdapter.notifyDataSetChanged()

            }

        }
    }

    private fun setUpTabs() {

        val adapter = HomeFragmentViewPagerAdapter(childFragmentManager)
        adapter.addFragment(HomeMoviesFragment(), "Movie")
        adapter.addFragment(HomePeopleFragment(), "People")
        adapter.addFragment(HomeTvFragment(), "Tv")
        homeViewPager.adapter = adapter
        homeTabLayout.setupWithViewPager(homeViewPager)

    }
}