package com.muzafferatmaca.tmdb_movie_app.model.personmodel

import com.google.gson.annotations.SerializedName

data class PersonCreditsResponse(
    @SerializedName("cast")
    val cast: ArrayList<Cast>?,
    @SerializedName("crew")
    val crew: List<Crew?>?,
    @SerializedName("id")
    val id: Int?
)