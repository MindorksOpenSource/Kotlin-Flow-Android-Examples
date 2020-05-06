package com.mindorks.kotlinFlow.learn.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mindorks.kotlinFlow.data.api.ApiHelper
import com.mindorks.kotlinFlow.data.local.DatabaseHelper
import com.mindorks.kotlinFlow.data.local.entity.User
import com.mindorks.kotlinFlow.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class RoomDBViewModel(private val apiHelper: ApiHelper, private val dbHelper: DatabaseHelper) :
    ViewModel() {

    private val users = MutableLiveData<Resource<List<User>>>()

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            users.postValue(Resource.loading(null))
            dbHelper.getUsers()
                .flatMapConcat { usersFromDb ->
                    if (usersFromDb.isEmpty()) {
                        return@flatMapConcat apiHelper.getUsers()
                            .map { apiUserList ->
                                val userList = mutableListOf<User>()
                                for (apiUser in apiUserList) {
                                    val user = User(
                                        apiUser.id,
                                        apiUser.name,
                                        apiUser.email,
                                        apiUser.avatar
                                    )
                                    userList.add(user)
                                }
                                userList
                            }
                            .flatMapConcat { usersToInsertInDB ->
                                dbHelper.insertAll(usersToInsertInDB)
                                    .flatMapConcat {
                                        flow {
                                            emit(usersToInsertInDB)
                                        }
                                    }
                            }
                    } else {
                        return@flatMapConcat flow {
                            emit(usersFromDb)
                        }
                    }
                }
                .flowOn(Dispatchers.Default)
                .catch { e ->
                    users.postValue(Resource.error(e.toString(), null))
                }
                .collect {
                    users.postValue(Resource.success(it))
                }
        }
    }

    fun getUsers(): LiveData<Resource<List<User>>> {
        return users
    }

}