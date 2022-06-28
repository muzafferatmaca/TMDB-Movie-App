package com.muzafferatmaca.tmdb_movie_app.ui.home.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.muzafferatmaca.tmdb_movie_app.R
import com.muzafferatmaca.tmdb_movie_app.databinding.HomeItemTabMovieBinding
import com.muzafferatmaca.tmdb_movie_app.model.homemodel.search.SearchResult

class HomeMoviesAdapter(var movieList : List<SearchResult>) : RecyclerView.Adapter<HomeMoviesAdapter.ViewHolder>() {


    class ViewHolder(val itemBinding : HomeItemTabMovieBinding) : RecyclerView.ViewHolder(itemBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<HomeItemTabMovieBinding>(inflater, R.layout.home_item_movie,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = movieList.size
}