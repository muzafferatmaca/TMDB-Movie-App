package com.muzafferatmaca.tmdb_movie_app.ui.home.people

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.muzafferatmaca.tmdb_movie_app.R
import com.muzafferatmaca.tmdb_movie_app.databinding.HomeItemTabPeopleBinding
import com.muzafferatmaca.tmdb_movie_app.model.homemodel.search.SearchResult

class HomePeopleAdapter(var movieList : List<SearchResult>) : RecyclerView.Adapter<HomePeopleAdapter.ViewHolder>() {


    class ViewHolder(val itemBinding : HomeItemTabPeopleBinding) : RecyclerView.ViewHolder(itemBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<HomeItemTabPeopleBinding>(inflater, R.layout.home_item_movie,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = movieList.size
}