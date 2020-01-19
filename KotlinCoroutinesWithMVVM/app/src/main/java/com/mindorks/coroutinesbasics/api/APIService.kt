package com.mindorks.coroutinesbasics.api

import com.mindorks.coroutinesbasics.model.APIResponse
import com.mindorks.coroutinesbasics.util.Result
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface APIService {

    @GET("api/users")
    fun fetchDataFromAPI(): Deferred<Response<APIResponse>>
}