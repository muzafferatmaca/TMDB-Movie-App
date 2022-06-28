package com.muzafferatmaca.tmdb_movie_app.utils

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.muzafferatmaca.tmdb_movie_app.R

fun ImageView.downloadFromUrl(url : String?, progressDrawable: CircularProgressDrawable){

    val options = RequestOptions()
        .placeholder(progressDrawable)
        .error(R.color.black)

    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(if (url?.isNotEmpty() == true) "${Constant.BASE_IMAGE_URL}$url" else null)
        .centerCrop()
        .into(this)



}

fun placeholderProgressBar(context: Context) : CircularProgressDrawable{

    return CircularProgressDrawable(context).apply {
        strokeWidth = 8f
        centerRadius = 40f
        start()
    }

}

@BindingAdapter("android:downloadUrl")
fun downloadImage(view : ImageView,url : String?){

    view.downloadFromUrl(url, placeholderProgressBar(view.context))

}