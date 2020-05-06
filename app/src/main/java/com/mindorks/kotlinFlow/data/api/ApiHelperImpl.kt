package com.mindorks.kotlinFlow.data.api

import kotlinx.coroutines.flow.flow

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {

    override fun getUsers() = flow { emit(apiService.getUsers()) }

    override fun getMoreUsers() = flow { emit(apiService.getMoreUsers()) }

    override fun getUsersWithError() = flow { emit(apiService.getUsersWithError()) }

}