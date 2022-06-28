package com.muzafferatmaca.tmdb_movie_app.ui.persondetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.muzafferatmaca.tmdb_movie_app.R
import com.muzafferatmaca.tmdb_movie_app.databinding.FragmentMovieDetailBinding
import com.muzafferatmaca.tmdb_movie_app.model.personmodel.PersonDetailResponse

class PersonDetailAdapter (var detailList: List<PersonDetailResponse>) : RecyclerView.Adapter<PersonDetailAdapter.ViewHolder>()  {

    class ViewHolder(val itemBinding: FragmentMovieDetailBinding) : RecyclerView.ViewHolder(itemBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<FragmentMovieDetailBinding>(inflater, R.layout.fragment_person_detail, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {



    }

    override fun getItemCount(): Int = detailList.size
}