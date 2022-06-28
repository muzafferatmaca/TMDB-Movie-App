package com.muzafferatmaca.tmdb_movie_app.service

import com.muzafferatmaca.tmdb_movie_app.model.detailmodel.MovieDetailResponse
import com.muzafferatmaca.tmdb_movie_app.model.homemodel.MovieResponse
import com.muzafferatmaca.tmdb_movie_app.model.homemodel.search.SearchResponse
import com.muzafferatmaca.tmdb_movie_app.utils.Constant
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MovieRetrofit {

    private val retrofit = Retrofit.Builder()
        .baseUrl(Constant.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(MovieService::class.java)

    fun getPopularMovie() : Single<MovieResponse> {
        return retrofit.getPopularMovies()
    }

    fun getSearchMoviePeopleTv(query : String) : Single<SearchResponse>{
        return  retrofit.searchMoviePeopleTv(Constant.API_KEY ,query)
    }

    fun getMovieDetail(id : Int) : Single<MovieDetailResponse>{
        return retrofit.getMovieDetail(id,Constant.API_KEY)
    }


}