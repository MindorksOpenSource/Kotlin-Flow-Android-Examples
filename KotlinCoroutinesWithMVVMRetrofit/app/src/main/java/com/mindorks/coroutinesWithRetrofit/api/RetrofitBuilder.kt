package com.mindorks.coroutinesWithRetrofit.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object RetrofitBuilder {




    fun getRetrofit() : Retrofit {
        val BASE_URL  = "https://reqres.in/"
        return Retrofit.Builder()
            .baseUrl(BASE_URL) // YOUR BASE URL OF API
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(ScalarsConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }


    val apiService: APIService = getRetrofit().create(APIService::class.java)



}