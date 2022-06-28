package com.muzafferatmaca.tmdb_movie_app.model.homemodel.search

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val searchResults: List<SearchResult?>?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?
)