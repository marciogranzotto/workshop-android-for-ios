package com.example.ostanik.workshopapp

import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by ostanik on 2017-06-27.
 */
object RetrofitHelper {

    val retrofit = Retrofit.Builder()
            .baseUrl("http://r3desenhando.com.br:1880")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build()

}