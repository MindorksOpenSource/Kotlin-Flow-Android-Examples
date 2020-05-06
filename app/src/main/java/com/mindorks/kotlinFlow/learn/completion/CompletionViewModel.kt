package com.mindorks.kotlinFlow.learn.completion

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mindorks.kotlinFlow.data.api.ApiHelper
import com.mindorks.kotlinFlow.data.local.DatabaseHelper
import com.mindorks.kotlinFlow.utils.Resource
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.launch

class CompletionViewModel(
    private val apiHelper: ApiHelper,
    private val dbHelper: DatabaseHelper
) : ViewModel() {

    private val status = MutableLiveData<Resource<String>>()

    init{
        fetchUsers()
    }
    private fun fetchUsers() {
        viewModelScope.launch {
            status.postValue(Resource.loading(null))
            apiHelper.getUsers()
                .catch { e ->
                    status.postValue(Resource.error(e.toString(), null))
                }
                .onCompletion {
                    status.postValue(Resource.success("Task Completed"))
                }
                .collect {
                }
        }
    }

    fun getStatus(): LiveData<Resource<String>> {
        return status
    }
    
}