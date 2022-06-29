package com.muzafferatmaca.tmdb_movie_app.ui.persondetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.muzafferatmaca.tmdb_movie_app.R
import com.muzafferatmaca.tmdb_movie_app.databinding.ItemPersonTvBinding
import com.muzafferatmaca.tmdb_movie_app.model.personmodel.Cast

class PersonDetailTVAdapter(var tvList : List<Cast>) : RecyclerView.Adapter<PersonDetailTVAdapter.ViewHolder>() {

    class ViewHolder (val itemBinding : ItemPersonTvBinding): RecyclerView.ViewHolder(itemBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater  = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemPersonTvBinding>(inflater, R.layout.item_person_tv,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemBinding.itemTv = tvList[position]
    }

    override fun getItemCount(): Int =  tvList.size
}