package com.muzafferatmaca.tmdb_movie_app.ui.home.people

import android.os.Bundle

import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.muzafferatmaca.tmdb_movie_app.R
import com.muzafferatmaca.tmdb_movie_app.databinding.FragmentHomePeopleBinding
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

        setFragmentResultListener("requestKey") { key, bundle ->
            val queryText = bundle.getString("data")

            queryText?.let { viewModel.getSearchVM(it) }
            searchObserveLiveData()
        }


        recyclerViewHomePeople.layoutManager = GridLayoutManager(context, 3)
        val dividerItemDecoration = DividerItemDecoration(context, RecyclerView.VERTICAL)
        ResourcesCompat.getDrawable(resources,R.drawable.divider,null)?.let {
            dividerItemDecoration.setDrawable(it)
        }
        recyclerViewHomePeople.addItemDecoration(dividerItemDecoration)

        recyclerViewHomePeople.adapter = homePeopleAdapter

    }

    private fun searchObserveLiveData() {

        viewModel.searchMovie.observe(viewLifecycleOwner) { searchResponse ->

            searchResponse.searchResults?.let {

                recyclerViewHomePeople.visibility = View.VISIBLE
                homePeopleAdapter.movieList = it
                homePeopleAdapter.notifyDataSetChanged()

            }

        }

    }


}