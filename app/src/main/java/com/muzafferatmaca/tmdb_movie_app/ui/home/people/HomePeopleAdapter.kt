package com.muzafferatmaca.tmdb_movie_app.ui.home.people

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.muzafferatmaca.tmdb_movie_app.R
import com.muzafferatmaca.tmdb_movie_app.databinding.HomeItemTabPeopleBinding
import com.muzafferatmaca.tmdb_movie_app.model.homemodel.search.SearchResult
import com.muzafferatmaca.tmdb_movie_app.ui.home.HomeFragmentDirections
import com.muzafferatmaca.tmdb_movie_app.utils.ItemClick
import kotlinx.android.synthetic.main.home_item_tab_people.view.*

class HomePeopleAdapter(var movieList : List<SearchResult>) : RecyclerView.Adapter<HomePeopleAdapter.ViewHolder>() ,ItemClick{


    class ViewHolder(val itemBinding : HomeItemTabPeopleBinding) : RecyclerView.ViewHolder(itemBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<HomeItemTabPeopleBinding>(inflater, R.layout.home_item_tab_people,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemBinding.tabPeople = movieList[position]
        holder.itemBinding.listener = this

    }

    override fun getItemCount(): Int = movieList.size

    override fun onItemClick(view: View) {
        val personId = view.personIdTexView.text.toString().toInt()
        val action = HomeFragmentDirections.actionHomeFragmentToPersonDetailFragment(personId)
        Navigation.findNavController(view).navigate(action)
    }
}