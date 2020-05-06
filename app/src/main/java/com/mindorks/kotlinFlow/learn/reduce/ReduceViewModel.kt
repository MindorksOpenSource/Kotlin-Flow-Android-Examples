package com.mindorks.kotlinFlow.learn.reduce

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mindorks.kotlinFlow.data.api.ApiHelper
import com.mindorks.kotlinFlow.data.local.DatabaseHelper
import com.mindorks.kotlinFlow.utils.Resource
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.launch

class ReduceViewModel(
    val apiHelper: ApiHelper,
    dbHelper: DatabaseHelper
) : ViewModel() {

    private val status = MutableLiveData<Resource<String>>()

    fun startReduceTask() {
        viewModelScope.launch {
            status.postValue(Resource.loading(null))
            val result = (1..5).asFlow()
                .reduce { a, b -> a + b }

            status.postValue(Resource.success(result.toString()))
        }
    }

    fun getStatus(): LiveData<Resource<String>> {
        return status
    }

}