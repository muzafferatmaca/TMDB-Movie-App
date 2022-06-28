package com.muzafferatmaca.tmdb_movie_app.ui.home.tv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.muzafferatmaca.tmdb_movie_app.R
import com.muzafferatmaca.tmdb_movie_app.databinding.HomeItemTabTvBinding
import com.muzafferatmaca.tmdb_movie_app.model.homemodel.search.SearchResult

class HomeTvAdapter(var movieList : List<SearchResult>) : RecyclerView.Adapter<HomeTvAdapter.ViewHolder>() {


    class ViewHolder(val itemBinding : HomeItemTabTvBinding) : RecyclerView.ViewHolder(itemBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<HomeItemTabTvBinding>(inflater, R.layout.home_item_tab_tv,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemBinding.tabTv =  movieList[position]

    }

    override fun getItemCount(): Int = movieList.size
}