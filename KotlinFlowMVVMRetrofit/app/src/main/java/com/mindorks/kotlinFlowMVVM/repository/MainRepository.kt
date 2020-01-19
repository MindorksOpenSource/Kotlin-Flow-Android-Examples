package com.mindorks.kotlinFlowMVVM.repository

import com.mindorks.kotlinFlowMVVM.api.RetrofitBuilder
import com.mindorks.kotlinFlowMVVM.model.APIResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class MainRepository {

    fun getAPIData(): Flow<Response<APIResponse>> {
        return flow {
            emit(RetrofitBuilder.apiService.fetchDataFromAPI())
        }
    }

}