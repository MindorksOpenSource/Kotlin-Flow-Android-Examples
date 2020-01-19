package com.mindorks.kotlinFlowMVVM.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.mindorks.kotlinFlowMVVM.R
import com.mindorks.kotlinFlowMVVM.adapter.RecyclerViewAdapter
import com.mindorks.kotlinFlowMVVM.model.DataItem
import com.mindorks.kotlinFlowMVVM.util.NetworkResult
import com.mindorks.kotlinFlowMVVM.util.gone
import com.mindorks.kotlinFlowMVVM.util.show
import com.mindorks.kotlinFlowMVVM.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    lateinit var adapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUI()
        setupViewModel()
        setupAPICall()

    }

    private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RecyclerViewAdapter(arrayListOf()) {
            Toast.makeText(this, "My Name is ${it.firstName} ${it.lastName}", Toast.LENGTH_LONG)
                .show()
        }
        recyclerView.adapter = adapter
    }

    private fun setupAPICall() {
        mainViewModel.getAPIResponse()
        mainViewModel.getResponse().observe(this, Observer {
            when (it.status) {
                NetworkResult.Status.SUCCESS -> {
                    progressBar.gone()
                    it.data?.data?.let { list -> renderList(list) }
                    recyclerView.show()
                }
                NetworkResult.Status.LOADING -> {
                    progressBar.show()
                    recyclerView.gone()

                }
                NetworkResult.Status.ERROR -> {
                    //Handle Error
                }
            }
        })
    }

    private fun renderList(list: ArrayList<DataItem>) {
        adapter.addData(list)
        adapter.notifyDataSetChanged()
    }

    private fun setupViewModel() {
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
    }


}
