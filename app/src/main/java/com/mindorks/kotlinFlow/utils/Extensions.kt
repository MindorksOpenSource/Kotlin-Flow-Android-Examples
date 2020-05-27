package com.mindorks.kotlinFlow.utils

import android.widget.SearchView
import kotlinx.coroutines.flow.MutableStateFlow

fun SearchView.getQueryTextChangeStateFlow(): MutableStateFlow<String> {

    val query = MutableStateFlow("")

    setOnQueryTextListener(object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String?): Boolean {
            return true
        }

        override fun onQueryTextChange(newText: String): Boolean {
            query.value = newText
            return true
        }
    })

    return query

}