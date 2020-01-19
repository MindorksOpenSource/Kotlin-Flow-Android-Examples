package com.mindorks.coroutinesWithRetrofit.repository

import com.mindorks.coroutinesWithRetrofit.api.RetrofitBuilder

class MainRepository {

    suspend fun getAPIData() = RetrofitBuilder.apiService.fetchDataFromAPI().await()

}