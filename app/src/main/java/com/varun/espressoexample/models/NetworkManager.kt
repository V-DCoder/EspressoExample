package com.varun.espressoexample.models

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NetworkManager {

    var api: APIInterface = Retrofit.Builder()
        .baseUrl("http://api-cdn.apixu.com/v1/")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(APIInterface::class.java)

    fun loadData(): Single<ForeCastResponse> {
        return api.getForecast("59460b369b54495c866121659192908", "mumbai").observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }

}