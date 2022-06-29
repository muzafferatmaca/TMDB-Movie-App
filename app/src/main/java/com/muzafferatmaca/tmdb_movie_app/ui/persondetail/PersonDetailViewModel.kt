package com.muzafferatmaca.tmdb_movie_app.ui.persondetail

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.muzafferatmaca.tmdb_movie_app.model.personmodel.Cast
import com.muzafferatmaca.tmdb_movie_app.model.personmodel.PersonCreditsResponse
import com.muzafferatmaca.tmdb_movie_app.model.personmodel.PersonDetailResponse
import com.muzafferatmaca.tmdb_movie_app.service.MovieRetrofit
import com.muzafferatmaca.tmdb_movie_app.ui.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class PersonDetailViewModel (application: Application): BaseViewModel(application) {

    private val retrofitService = MovieRetrofit()
    private val disposable = CompositeDisposable()

    val detailPerson = MutableLiveData<PersonDetailResponse>()
    val detailPersonError = MutableLiveData<Boolean>()
    val detailPersonLoading = MutableLiveData<Boolean>()

    val detailPersonMovieCredit = MutableLiveData<ArrayList<Cast>>()
    val detailPersonMovieCreditError = MutableLiveData<Boolean>()
    val detailPersonMovieCreditLoading = MutableLiveData<Boolean>()

    val detailPersonTVCredit = MutableLiveData<ArrayList<Cast>>()
    val detailPersonTVCreditError = MutableLiveData<Boolean>()
    val detailPersonTVCreditLoading = MutableLiveData<Boolean>()


    fun getPersonDetail(id : Int){

        detailPersonLoading.value = true
        detailPersonMovieCreditLoading.value = true
        detailPersonTVCreditLoading.value = true

        disposable.add(
            retrofitService.getPersonDetail(id = id)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object  : DisposableSingleObserver<PersonDetailResponse>(){
                    override fun onSuccess(t: PersonDetailResponse) {
                        detailPerson.value = t
                    }

                    override fun onError(e: Throwable) {
                      detailPersonError.value=true
                        detailPersonLoading.value = false
                        e.printStackTrace()
                    }


                })
        )

    disposable.add(
        retrofitService.getPersonMovieCredits(id)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<PersonCreditsResponse>(){
                override fun onSuccess(t: PersonCreditsResponse) {

                    detailPersonMovieCredit.value = t.cast

                }

                override fun onError(e: Throwable) {
                    detailPersonMovieCreditLoading.value=false
                    detailPersonMovieCreditError.value = true
                    e.printStackTrace()
                }

            })
    )

        disposable.add(
            retrofitService.getPersonTVCredits(id)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object  : DisposableSingleObserver<PersonCreditsResponse>(){
                    override fun onSuccess(t: PersonCreditsResponse) {
                        detailPersonTVCredit.value = t.cast
                    }

                    override fun onError(e: Throwable) {

                        detailPersonTVCreditError.value  = true
                        detailPersonTVCreditLoading.value = false
                        e.printStackTrace()
                    }

                })
        )


    }
}