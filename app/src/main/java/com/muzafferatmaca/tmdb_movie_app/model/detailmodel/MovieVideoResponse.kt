package com.muzafferatmaca.tmdb_movie_app.model.detailmodel


import com.google.gson.annotations.SerializedName

data class MovieVideoResponse(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("results")
    val results: List<Result?>?
)