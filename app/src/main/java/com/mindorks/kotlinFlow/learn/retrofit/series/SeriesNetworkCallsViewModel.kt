package com.mindorks.kotlinFlow.learn.retrofit.series

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mindorks.kotlinFlow.data.api.ApiHelper
import com.mindorks.kotlinFlow.data.local.DatabaseHelper
import com.mindorks.kotlinFlow.data.model.ApiUser
import com.mindorks.kotlinFlow.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class SeriesNetworkCallsViewModel(
    private val apiHelper: ApiHelper,
    private val dbHelper: DatabaseHelper
) : ViewModel() {

    private val users = MutableLiveData<Resource<List<ApiUser>>>()

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {

            val allUsersFromApi = mutableListOf<ApiUser>()
            apiHelper.getUsers()
                .onStart { users.postValue(Resource.loading(null)) }
                .flatMapConcat { usersFromApi ->
                    allUsersFromApi.addAll(usersFromApi)
                    apiHelper.getMoreUsers()
                }
                .flowOn(Dispatchers.Default)
                .catch { e ->
                    users.postValue(Resource.error(e.toString(), null))
                }
                .collect { moreUsersFromApi ->
                    allUsersFromApi.addAll(moreUsersFromApi)
                    users.postValue(Resource.success(allUsersFromApi))
                }
        }
    }

    fun getUsers(): LiveData<Resource<List<ApiUser>>> {
        return users
    }

}