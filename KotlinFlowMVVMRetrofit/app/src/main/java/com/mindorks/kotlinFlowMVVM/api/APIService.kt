package com.mindorks.kotlinFlowMVVM.api

import com.mindorks.kotlinFlowMVVM.model.APIResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface APIService {

    @GET("api/users")
   suspend fun fetchDataFromAPI(): Response<APIResponse>

}