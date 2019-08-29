package com.varun.espressoexample.models

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {

    @GET("forecast.json")
    fun getForecast(@Query("key") key: String, @Query("q") city: String): Single<ForeCastResponse>
}