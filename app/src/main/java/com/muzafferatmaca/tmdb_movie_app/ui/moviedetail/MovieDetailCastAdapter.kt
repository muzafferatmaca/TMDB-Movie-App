package com.muzafferatmaca.tmdb_movie_app.ui.moviedetail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.muzafferatmaca.tmdb_movie_app.R
import com.muzafferatmaca.tmdb_movie_app.databinding.ItemCastBinding
import com.muzafferatmaca.tmdb_movie_app.model.detailmodel.Cast
import com.muzafferatmaca.tmdb_movie_app.ui.home.HomeFragmentDirections
import com.muzafferatmaca.tmdb_movie_app.utils.ItemClick
import kotlinx.android.synthetic.main.home_item_movie.view.*
import kotlinx.android.synthetic.main.home_item_tab_people.view.*

class MovieDetailCastAdapter (var castList : List<Cast>): RecyclerView.Adapter<MovieDetailCastAdapter.ViewHolder>(),ItemClick {

    class ViewHolder (val itemBinding : ItemCastBinding): RecyclerView.ViewHolder(itemBinding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemCastBinding>(inflater, R.layout.item_cast, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemBinding.itemCast  =castList[position]
        holder.itemBinding.listener = this

    }

    override fun getItemCount(): Int = castList.size

    override fun onItemClick(view: View) {
      val personId = view.personIdTexView.text.toString().toInt()
        println("test2 $personId")
        val action = MovieDetailFragmentDirections.actionMovieDetailFragmentToPersonDetailFragment(personId,null)
        Navigation.findNavController(view).navigate(action)
    }


}