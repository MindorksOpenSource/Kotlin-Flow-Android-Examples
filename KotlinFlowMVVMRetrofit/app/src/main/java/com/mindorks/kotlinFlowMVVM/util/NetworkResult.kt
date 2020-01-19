package com.mindorks.kotlinFlowMVVM.util


class NetworkResult<T>(val status: Status, val data: T?, val message: String?) {

    enum class Status {
        SUCCESS, ERROR, LOADING
    }

    companion object {

        fun <T> success(data: T?): NetworkResult<T>? {
            return NetworkResult(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T?): NetworkResult<T> {
            return NetworkResult(Status.ERROR, data, msg)
        }

        fun <T> loading(data: T?): NetworkResult<T> {
            return NetworkResult(Status.LOADING, data, null)
        }


    }
}