package com.muzafferatmaca.tmdb_movie_app.ui.persondetail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.muzafferatmaca.tmdb_movie_app.R

import com.muzafferatmaca.tmdb_movie_app.databinding.ItemPersonMovieBinding
import com.muzafferatmaca.tmdb_movie_app.model.personmodel.Cast

class PersonDetailMovieAdapter(var movieList : List<Cast>) : RecyclerView.Adapter<PersonDetailMovieAdapter.ViewHolder>() {


    class ViewHolder  (val itemBinding : ItemPersonMovieBinding) : RecyclerView.ViewHolder(itemBinding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemPersonMovieBinding>(inflater,R.layout.item_person_movie,parent,false)
        return  ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.itemBinding.itemMovie = movieList[position]
    }

    override fun getItemCount(): Int = movieList.size


}