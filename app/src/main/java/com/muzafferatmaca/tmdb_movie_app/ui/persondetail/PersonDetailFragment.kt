package com.muzafferatmaca.tmdb_movie_app.ui.persondetail

import android.os.Bundle

import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.muzafferatmaca.tmdb_movie_app.R
import com.muzafferatmaca.tmdb_movie_app.databinding.FragmentPersonDetailBinding
import com.muzafferatmaca.tmdb_movie_app.ui.base.BaseFragment
import com.muzafferatmaca.tmdb_movie_app.ui.moviedetail.MovieDetailFragmentArgs
import com.muzafferatmaca.tmdb_movie_app.ui.moviedetail.MovieDetailViewModel

class PersonDetailFragment : BaseFragment<FragmentPersonDetailBinding>() {

    override val layoutId: Int = R.layout.fragment_person_detail
    private lateinit var viewModel: PersonDetailViewModel
    private var personId: Int = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            personId = PersonDetailFragmentArgs.fromBundle(it).id
        }
        viewModel = ViewModelProvider(this).get(PersonDetailViewModel::class.java)

        viewModel.getPersonDetail(personId)
        observeLiveData()

    }

    fun observeLiveData(){

        viewModel.detailPerson.observe(viewLifecycleOwner) { detailResponse ->

            detailResponse.let {

                binding.person=it

            }

        }



    }
}