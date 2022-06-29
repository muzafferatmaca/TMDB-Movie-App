package com.muzafferatmaca.tmdb_movie_app.ui.persondetail

import android.os.Bundle

import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.muzafferatmaca.tmdb_movie_app.R
import com.muzafferatmaca.tmdb_movie_app.databinding.FragmentPersonDetailBinding
import com.muzafferatmaca.tmdb_movie_app.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_movie_detail.*
import kotlinx.android.synthetic.main.fragment_person_detail.*

class PersonDetailFragment : BaseFragment<FragmentPersonDetailBinding>() {

    override val layoutId: Int = R.layout.fragment_person_detail
    private lateinit var viewModel: PersonDetailViewModel
    private var personId: Int = 0
    private var personDetailMovieAdapter = PersonDetailMovieAdapter(arrayListOf())
    private var personDetailTVAdapter = PersonDetailTVAdapter(arrayListOf())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            personId = PersonDetailFragmentArgs.fromBundle(it).id
        }

        viewModel = ViewModelProvider(this).get(PersonDetailViewModel::class.java)
        viewModel.getPersonDetail(personId)

        detailPersonMovieRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        detailPersonMovieRecyclerView.setHasFixedSize(true)
        detailPersonMovieRecyclerView.adapter = personDetailMovieAdapter

        detailPersonTvRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        detailPersonTvRecyclerView.setHasFixedSize(true)
        detailPersonTvRecyclerView.adapter = personDetailTVAdapter

        observeLiveData()

    }

    fun observeLiveData(){

        viewModel.detailPerson.observe(viewLifecycleOwner) { detailResponse ->

            detailResponse.let {

                binding.person=it

            }

        }

        viewModel.detailPersonMovieCredit.observe(viewLifecycleOwner){personMovieResponse ->

            personMovieResponse?.let {

                detailPersonMovieRecyclerView.visibility = View.VISIBLE
                personDetailMovieAdapter.movieList = it
                personDetailMovieAdapter.notifyDataSetChanged()

            }
        }

        viewModel.detailPersonTVCredit.observe(viewLifecycleOwner){personTvResponse ->


            personTvResponse?.let {

                detailPersonTvRecyclerView.visibility = View.VISIBLE
                personDetailTVAdapter.tvList = it
                personDetailTVAdapter.notifyDataSetChanged()

            }

        }



    }
}