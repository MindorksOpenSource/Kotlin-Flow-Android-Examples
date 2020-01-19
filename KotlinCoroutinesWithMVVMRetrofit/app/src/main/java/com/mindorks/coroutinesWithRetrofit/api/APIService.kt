package com.mindorks.coroutinesWithRetrofit.api

import com.mindorks.coroutinesWithRetrofit.model.APIResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface APIService {

    @GET("api/users")
    fun fetchDataFromAPI(): Deferred<Response<APIResponse>>

}