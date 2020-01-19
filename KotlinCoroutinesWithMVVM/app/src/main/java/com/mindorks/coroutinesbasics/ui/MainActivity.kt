package com.mindorks.coroutinesbasics.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.gson.Gson
import com.mindorks.coroutinesbasics.R
import com.mindorks.coroutinesbasics.util.Result
import com.mindorks.coroutinesbasics.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewModel()
        setupAPICall()

    }

    private fun setupAPICall() {
        mainViewModel.getAPIResponse()
        mainViewModel.getResponse().observe(this, Observer {
            when (it.status){
                Result.Status.SUCCESS->{Log.d("MainActivity",Gson().toJson(it.data))}
                Result.Status.LOADING->{Log.d("MainActivity",Gson().toJson(true))}
                Result.Status.ERROR->{Log.d("MainActivity",Gson().toJson(it.message))}
            }
        })
    }

    private fun setupViewModel() {
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
    }


}
