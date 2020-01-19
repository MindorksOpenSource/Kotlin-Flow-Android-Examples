package com.mindorks.coroutinesbasics.repository

import com.mindorks.coroutinesbasics.api.RetrofitBuilder

class MainRepository {

    suspend fun getAPIData() = RetrofitBuilder.apiService.fetchDataFromAPI().await()

}