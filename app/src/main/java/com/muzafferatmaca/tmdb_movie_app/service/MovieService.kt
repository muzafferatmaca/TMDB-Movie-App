package com.muzafferatmaca.tmdb_movie_app.service

import com.muzafferatmaca.tmdb_movie_app.model.detailmodel.MovieDetailResponse
import com.muzafferatmaca.tmdb_movie_app.model.homemodel.MovieResponse
import com.muzafferatmaca.tmdb_movie_app.model.homemodel.search.SearchResponse
import com.muzafferatmaca.tmdb_movie_app.model.personmodel.PersonDetailResponse
import com.muzafferatmaca.tmdb_movie_app.utils.Constant
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {

    @GET("movie/popular")
     fun getPopularMovies(
        @Query("api_key")  key : String = Constant.API_KEY
     ): Single<MovieResponse>

    @GET("search/multi")
     fun searchMoviePeopleTv(
        @Query("api_key")  key : String = Constant.API_KEY,
        @Query("query") query: String?
    ): Single<SearchResponse>

    @GET("movie/{movie_id}")
     fun getMovieDetail(
        @Path("movie_id") movie_id: Int,
        @Query("api_key")  key : String = Constant.API_KEY,
    ): Single<MovieDetailResponse>

    @GET("person/{person_id}")
     fun getPersonDetail(
        @Path("person_id") person_id: Int,
        @Query("api_key")  key : String = Constant.API_KEY,
    ): Single<PersonDetailResponse>






}