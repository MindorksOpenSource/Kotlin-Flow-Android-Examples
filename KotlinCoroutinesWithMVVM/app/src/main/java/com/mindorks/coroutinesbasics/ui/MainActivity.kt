package com.mindorks.coroutinesbasics.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.mindorks.coroutinesbasics.R
import com.mindorks.coroutinesbasics.adapter.RecyclerViewAdapter
import com.mindorks.coroutinesbasics.model.DataItem
import com.mindorks.coroutinesbasics.util.Result
import com.mindorks.coroutinesbasics.util.gone
import com.mindorks.coroutinesbasics.util.show
import com.mindorks.coroutinesbasics.viewmodel.MainViewModel
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
                Result.Status.SUCCESS -> {
                    progressBar.gone()
                    it.data?.data?.let { list -> renderList(list) }
                    recyclerView.show()
                }
                Result.Status.LOADING -> {
                    progressBar.show()
                    recyclerView.gone()

                }
                Result.Status.ERROR -> {
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
