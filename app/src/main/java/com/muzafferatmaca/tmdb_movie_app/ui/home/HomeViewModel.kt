package com.muzafferatmaca.tmdb_movie_app.ui.home

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.muzafferatmaca.tmdb_movie_app.model.homemodel.MovieResponse
import com.muzafferatmaca.tmdb_movie_app.model.homemodel.search.SearchResponse
import com.muzafferatmaca.tmdb_movie_app.service.MovieRetrofit
import com.muzafferatmaca.tmdb_movie_app.ui.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class HomeViewModel(application: Application) : BaseViewModel(application) {

    private val retrofitService = MovieRetrofit()
    private val disposable = CompositeDisposable()

    val popularMovie = MutableLiveData<MovieResponse>()
    val popularMovieError = MutableLiveData<Boolean>()
    val popularMovieLoading = MutableLiveData<Boolean>()

    val searchMovie = MutableLiveData<SearchResponse>()
    val searchMovieError = MutableLiveData<Boolean>()
    val searchMovieLoading = MutableLiveData<Boolean>()

    fun getPopularMovieVM() {

        popularMovieLoading.value = true

        disposable.add(
            retrofitService.getPopularMovie()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<MovieResponse>() {
                    override fun onSuccess(t: MovieResponse) {

                        popularMovie.value = t

                        println("test $t")

                    }

                    override fun onError(e: Throwable) {
                        popularMovieError.value = true
                        popularMovieLoading.value = false
                        e.printStackTrace()
                    }

                })
        )

    }

    fun getSearchVM(query: String) {

        searchMovieLoading.value = true

        disposable.add(
            retrofitService.getSearchMoviePeopleTv(query = query)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<SearchResponse>() {
                    override fun onSuccess(t: SearchResponse) {
                        searchMovie.value = t
                    }

                    override fun onError(e: Throwable) {
                        searchMovieError.value = true
                        popularMovieLoading.value = false
                        e.printStackTrace()
                    }

                })
        )

    }

    override fun onCleared() {
        super.onCleared()

        disposable.clear()
    }

}