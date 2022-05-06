package com.example.sravnitest.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.sravnitest.data.RetrofitClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit

class GeneralFragmentViewModel: ViewModel() {
    private val disposable = CompositeDisposable()
    private var retrofitClient: RetrofitClient? = null
    private var retrofit: Retrofit? = null


    init {
        retrofitClient = RetrofitClient
        retrofit = retrofitClient!!.getRetrofit()
        getDataFromServer()
    }

    fun getDataFromServer(){
        disposable.add(retrofitClient!!.api.getOffersFromServer(listOf(1, 2, 3))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{
                    it ->
                Log.e("XXX", it.actionText)
            })
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }
}