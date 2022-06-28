package com.muzafferatmaca.tmdb_movie_app.ui.moviedetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.muzafferatmaca.tmdb_movie_app.R
import com.muzafferatmaca.tmdb_movie_app.databinding.FragmentMovieDetailBinding
import com.muzafferatmaca.tmdb_movie_app.model.detailmodel.MovieDetailResponse

class DetailAdapter (var detailList: List<MovieDetailResponse>) : RecyclerView.Adapter<DetailAdapter.ViewHolder>()  {

    class ViewHolder(val itemBinding: FragmentMovieDetailBinding) : RecyclerView.ViewHolder(itemBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<FragmentMovieDetailBinding>(inflater, R.layout.fragment_movie_detail, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemBinding.movie = detailList[position]

    }

    override fun getItemCount(): Int = detailList.size
}