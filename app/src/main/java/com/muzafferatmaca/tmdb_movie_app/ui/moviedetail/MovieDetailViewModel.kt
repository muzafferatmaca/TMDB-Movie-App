package com.muzafferatmaca.tmdb_movie_app.ui.moviedetail

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.muzafferatmaca.tmdb_movie_app.model.detailmodel.Cast
import com.muzafferatmaca.tmdb_movie_app.model.detailmodel.MovieCreditsResponse
import com.muzafferatmaca.tmdb_movie_app.model.detailmodel.MovieDetailResponse
import com.muzafferatmaca.tmdb_movie_app.service.MovieRetrofit
import com.muzafferatmaca.tmdb_movie_app.ui.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class MovieDetailViewModel(application: Application) : BaseViewModel(application) {

    private val retrofitService = MovieRetrofit()
    private val disposable = CompositeDisposable()

    val detailMovie = MutableLiveData<MovieDetailResponse>()
    val detailMovieError = MutableLiveData<Boolean>()
    val detailMovieLoading = MutableLiveData<Boolean>()

    val detailMovieCredits = MutableLiveData<ArrayList<Cast>>()
    val detailMovieCreditsError = MutableLiveData<Boolean>()
    val detailMovieCreditsLoading = MutableLiveData<Boolean>()


    fun getMovieDetail(id: Int) {

        detailMovieLoading.value = true
        detailMovieCreditsLoading.value = true

        disposable.add(
            retrofitService.getMovieDetail(id)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<MovieDetailResponse>() {
                    override fun onSuccess(t: MovieDetailResponse) {


                        detailMovie.value = t

                    }

                    override fun onError(e: Throwable) {
                        detailMovieError.value = true
                        detailMovieLoading.value = false
                        e.printStackTrace()
                    }

                })

        )

        disposable.add(
            retrofitService.getMovieCredits(id)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<MovieCreditsResponse>() {
                    override fun onSuccess(t: MovieCreditsResponse) {

                        detailMovieCredits.value = t.cast

                    }

                    override fun onError(e: Throwable) {
                        detailMovieCreditsLoading.value = false
                        detailMovieCreditsError.value = true
                        e.printStackTrace()
                    }

                })
        )

    }
}