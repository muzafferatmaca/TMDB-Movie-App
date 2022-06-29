package com.muzafferatmaca.tmdb_movie_app.model.detailmodel

import com.google.gson.annotations.SerializedName

data class MovieCreditsResponse(
    @SerializedName("cast")
    val cast: ArrayList<Cast>?,
    @SerializedName("crew")
    val crew: List<Crew?>?,
    @SerializedName("id")
    val id: Int?
)