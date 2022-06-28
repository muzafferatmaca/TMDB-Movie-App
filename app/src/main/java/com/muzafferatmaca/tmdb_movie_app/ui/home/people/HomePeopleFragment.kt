package com.muzafferatmaca.tmdb_movie_app.ui.home.people

import android.os.Bundle

import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.muzafferatmaca.tmdb_movie_app.R
import com.muzafferatmaca.tmdb_movie_app.databinding.FragmentHomePeopleBinding
import com.muzafferatmaca.tmdb_movie_app.model.homemodel.search.SearchResult
import com.muzafferatmaca.tmdb_movie_app.ui.base.BaseFragment
import com.muzafferatmaca.tmdb_movie_app.ui.home.HomeViewModel

import kotlinx.android.synthetic.main.fragment_home_people.*

class HomePeopleFragment : BaseFragment<FragmentHomePeopleBinding>() {

    override val layoutId: Int = R.layout.fragment_home_people
    private lateinit var viewModel: HomeViewModel
    private val homePeopleAdapter = HomePeopleAdapter(arrayListOf())


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        recyclerViewHomePeople.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewHomePeople.setHasFixedSize(true)
        recyclerViewHomePeople.adapter = homePeopleAdapter

        searchObserveLiveData()
    }

    private fun searchObserveLiveData() {

        viewModel.searchMovie.observe(viewLifecycleOwner) { searchResponse ->

            searchResponse.searchResults?.let {

                recyclerViewHomePeople.visibility = View.VISIBLE
                homePeopleAdapter.movieList = it as List<SearchResult>
                homePeopleAdapter.notifyDataSetChanged()

            }

        }

    }


}