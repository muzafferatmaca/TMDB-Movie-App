package com.muzafferatmaca.tmdb_movie_app.model.detailmodel

import com.google.gson.annotations.SerializedName

data class ProductionCompany(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("logo_path")
    val logoPath: Any?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("origin_country")
    val originCountry: String?
)