package com.mindorks.kotlinFlow.learn.filter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mindorks.kotlinFlow.data.api.ApiHelper
import com.mindorks.kotlinFlow.data.local.DatabaseHelper
import com.mindorks.kotlinFlow.utils.Resource
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch

class FilterViewModel(
    apiHelper: ApiHelper,
    dbHelper: DatabaseHelper
) : ViewModel() {
    private val status = MutableLiveData<Resource<String>>()

    fun startFilterTask() {
        viewModelScope.launch {

            val result = mutableListOf<Int>()
            (1..5).asFlow()
                .onStart {  status.postValue(Resource.loading(null))  }
                .filter {
                    it % 2 == 0
                }
                .toList(result)

            status.postValue(Resource.success(result.toString()))
        }
    }

    fun getStatus(): LiveData<Resource<String>> {
        return status
    }

}