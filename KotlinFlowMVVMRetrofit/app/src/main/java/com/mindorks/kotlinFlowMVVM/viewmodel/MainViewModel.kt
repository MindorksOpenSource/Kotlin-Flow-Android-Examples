package com.mindorks.kotlinFlowMVVM.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mindorks.kotlinFlowMVVM.model.APIResponse
import com.mindorks.kotlinFlowMVVM.repository.MainRepository
import com.mindorks.kotlinFlowMVVM.util.NetworkResult
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val mainRepository = MainRepository()
    private val apiResponse = MutableLiveData<NetworkResult<APIResponse>>()
    fun getResponse(): LiveData<NetworkResult<APIResponse>> = apiResponse

    fun getAPIResponse() {
        viewModelScope.launch {
            apiResponse.postValue(NetworkResult.loading(null))
            mainRepository.getAPIData().collect {
                apiResponse.postValue(NetworkResult.success(it.body()))
            }
        }
    }

//    Other way to do it
//    fun getAPIResponse() {
//        mainRepository.getAPIData().asLiveData()
//    }
}