package com.muzafferatmaca.tmdb_movie_app.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.muzafferatmaca.tmdb_movie_app.R
import com.muzafferatmaca.tmdb_movie_app.databinding.HomeItemMovieBinding
import com.muzafferatmaca.tmdb_movie_app.model.homemodel.Result
import com.muzafferatmaca.tmdb_movie_app.utils.ItemClick
import kotlinx.android.synthetic.main.home_item_movie.view.*

class HomeAdapter(var movieList: List<Result>) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() ,ItemClick{


    class ViewHolder(val itemBinding: HomeItemMovieBinding) : RecyclerView.ViewHolder(itemBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<HomeItemMovieBinding>(inflater, R.layout.home_item_movie, parent, false)
        
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemBinding.movie = movieList[position]
        holder.itemBinding.listener = this
    }

    override fun getItemCount(): Int = movieList.size

    override fun onItemClick(view: View) {
        val movieId = view.movieIdTextView.text.toString().toInt()
        val action = HomeFragmentDirections.actionHomeFragmentToMovieDetailFragment(movieId)
        Navigation.findNavController(view).navigate(action)
    }
}
