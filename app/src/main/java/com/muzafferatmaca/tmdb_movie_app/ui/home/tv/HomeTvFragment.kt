package com.muzafferatmaca.tmdb_movie_app.ui.home.tv

import android.os.Bundle

import android.view.View
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.muzafferatmaca.tmdb_movie_app.R
import com.muzafferatmaca.tmdb_movie_app.databinding.FragmentHomeTvBinding
import com.muzafferatmaca.tmdb_movie_app.ui.base.BaseFragment
import com.muzafferatmaca.tmdb_movie_app.ui.home.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home_movies.*
import kotlinx.android.synthetic.main.fragment_home_tv.*


class HomeTvFragment : BaseFragment<FragmentHomeTvBinding>() {

    override val layoutId: Int = R.layout.fragment_home_tv
    private lateinit var viewModel: HomeViewModel
    private val homeTvAdapter = HomeTvAdapter(arrayListOf())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        lifecycleScope.launchWhenResumed {
            setFragmentResultListener("requestKey") { key, bundle ->
                val queryText = bundle.getString("data")
                queryText?.let { viewModel.getSearchVM(it) }
            }
        }

        recyclerViewHomeTv.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewHomeTv.setHasFixedSize(true)
        recyclerViewHomeTv.adapter = homeTvAdapter
        searchObserveLiveData()
    }

    private fun searchObserveLiveData() {

        viewModel.searchMovie.observe(viewLifecycleOwner) { searchResponse ->

            searchResponse.searchResults?.let {

                recyclerViewHomeMovie.visibility = View.VISIBLE
                homeTvAdapter.movieList = it
                homeTvAdapter.notifyDataSetChanged()

            }

        }

    }

}